package networks;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.PushbackInputStream;
import java.io.RandomAccessFile;
import java.net.Socket;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Random;


import org.json.JSONArray;
import org.json.JSONObject;

import base.FileLog;

public class PooledConnectionHandler implements Runnable {
	protected Socket connection;
	protected static List<Socket> pool = new LinkedList<Socket>();
	static String cmdStart = ">>";
	static String cmdEnd = "<<";
	 
	private Map<Long, FileLog> datas = new HashMap<Long, FileLog>();
	private String uploadPath="D:/uploadFile/";


	 
	public PooledConnectionHandler() {
	}

	public void handleConnection() {
		@SuppressWarnings("unused")
		Random random = new Random();
	 
		try {
			 
			InputStream inputStream=connection.getInputStream();
			BufferedReader is = new BufferedReader(new InputStreamReader(inputStream, "utf-8"));	 







			String line = is.readLine().toString();
			if(line.contains("Content-Length")==true)
			{

				try {
					System.out.println("accepted connenction from "
							+ connection.getInetAddress() + " @ " + connection.getPort());
					PushbackInputStream inStream = new PushbackInputStream(
							inputStream);
					
					
					String head=line;
					System.out.println("head:"+head);
					if (head != null) {
		 
						String[] items = head.split(";");
						String filelength = items[0].substring(items[0].indexOf("=") + 1);
						String filename = items[1].substring(items[1].indexOf("=") + 1);
						String sourceid = items[2].substring(items[2].indexOf("=") + 1);
						Long id = System.currentTimeMillis();
						FileLog log = null;
						if (null != sourceid && !"".equals(sourceid)) {
							id = Long.valueOf(sourceid);
							log = find(id);
						}
						File file = null;
						int position = 0;
						if(log==null){
							String path ="qufei";//new SimpleDateFormat("yyyy_MM_dd_HH_mm").format(new Date());
							File dir = new File(uploadPath+ path);
							if(!dir.exists()) dir.mkdirs();
							file = new File(dir, filename);
							if(file.exists()){
								filename = filename.substring(0, filename.indexOf(".")-1)+ dir.listFiles().length+ filename.substring(filename.indexOf("."));
								file = new File(dir, filename);
							}
							save(id, file);
						}else{
							file = new File(log.getPath()); 
							if(file.exists()){
								File logFile = new File(file.getParentFile(), file.getName()+".log");
								if(logFile.exists()){
									Properties properties = new Properties();
									properties.load(new FileInputStream(logFile));
									position = Integer.valueOf(properties.getProperty("length")); 
								}
							}
						}						
						OutputStream outStream = connection.getOutputStream();
						String response = "sourceid="+ id+ ";position="+ position+ ";filePath="+file.getPath()+"\r\n";
						
						System.out.print("�����ͻ���"+response.toString());
						outStream.write(response.getBytes());
						
						RandomAccessFile fileOutStream = new RandomAccessFile(file, "rwd");
						if(position==0) fileOutStream.setLength(Integer.valueOf(filelength));
						fileOutStream.seek(position);
						byte[] buffer = new byte[1024];
						int len = -1;
						int length = position;
						
						JSONArray imageJSONArray=new JSONArray();
						JSONObject imageJSON=new JSONObject();
						imageJSON.put("image", file.getPath());
						imageJSONArray.put(imageJSON);	
						
						while( (len=inStream.read(buffer)) != -1){
							fileOutStream.write(buffer, 0, len);
							length += len;
							Properties properties = new Properties();
							properties.put("length", String.valueOf(length));
							FileOutputStream logFile = new FileOutputStream(new File(file.getParentFile(), file.getName()+".log"));
							properties.store(logFile, null);
							logFile.close();
						}
						
						if(length==fileOutStream.length()) 
							delete(id);
						fileOutStream.close();							
						

						
						
						is.close();
						inStream.close();
						outStream.close();
						
						file = null;
						
					}
				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					try {
		                if(connection != null && !connection.isClosed()){
		                	is.close();
		                	connection.close();
		                	 
		                }
						 
		            } catch (IOException e) {}
				}
				
				
			}
			else
			{ 



			
				JSONArray r = null;
				try {
					System.out.println("from Client to Server:" + line);
					String cmd = line.substring(line.indexOf(cmdStart) + cmdStart.length(), line.indexOf(cmdEnd));
					String jsonStr = line.substring(line.indexOf("<<") + cmdEnd.length());
					r = new Mediator(cmd, jsonStr).process();
					PrintWriter os = new PrintWriter(connection.getOutputStream());
					// String res=handleString(r.toString());
					String res=null;

					if(r==null){
						res="error";
					}else{
						res	= r.toString();
					}
					System.out.println("from Server to Client:" + res);
					os.println(res);
					os.flush();
					os.close();


				}
				catch (Exception e) {
					// TODO: handle exception
					System.out.println("System:" + e.getMessage());
				}
				finally {






					is.close();
					connection.close();
				}

			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}

	}

	public String handleString(String s) {
		try {

			byte bb[] = s.getBytes("utf-8");
			s = new String(bb);
		}
		catch (Exception ee) {
		}
		return s;
	}
	public FileLog find(Long sourceid) {
		return datas.get(sourceid);
	}
	 
		public void save(Long id, File saveFile) {
			 
			datas.put(id, new FileLog(id, saveFile.getAbsolutePath()));
		}

		 
		public void delete(long sourceid) {
			if (datas.containsKey(sourceid))
				datas.remove(sourceid);
		}

	public static void processRequest(Socket requestToHandle) {
		synchronized (pool) {
			pool.add(pool.size(), requestToHandle);
			pool.notifyAll();
		}
	}

	@Override
	public void run() {
		while (true) {
			synchronized (pool) {
				while (pool.isEmpty()) {
					try {
						pool.wait();
					}
					catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				connection = (Socket) pool.remove(0);

			}
			handleConnection();
		}
	}
}
