-- ----------------------------------
-- user
-- ----------------------------------
insert into user (phone,password,nickname) values('1340713890','123456','liuwencai');
insert into user (phone,password,nickname) values('1340713891','123456','wencai123');
insert into user (phone,password,nickname) values('1340713892','123456','doke');
insert into user (phone,password,nickname) values('1340713894','123456','dsdsa');
-- ----------------------------------
-- shop
-- ----------------------------------

insert into shop(shopname,pic,longitude,latitude)value("武昌量贩","123.jpg",1.81920e+04,8.95400e+03);
insert into shop(shopname,pic,longitude,latitude)value("中百仓储","123.jpg",1.81920e+04,9.85600e+03);
insert into shop(shopname,pic,longitude,latitude)value("大洋百货","123.jpg",1.81920e+04,1.13190e+04);
insert into shop(shopname,pic,longitude,latitude)value("大毛超市","123.jpg",1.82720e+04,8.62400e+03);
insert into shop(shopname,pic,longitude,latitude)value("一食堂水果店","123.jpg",1.84160e+04,7.34800e+03);
insert into shop(shopname,pic,longitude,latitude)value("广信国际大酒店","123.jpg",1.84160e+04,8.29400e+03);
insert into shop(shopname,pic,longitude,latitude)value("苹果电子产品店","123.jpg",1.20000e+03,1.14400e+04);
insert into shop(shopname,pic,longitude,latitude)value("西八超市","123.jpg",1.20000e+03,2.68400e+03);
-- -----------------------------------------------------
-- -unit
-- -----------------------------------------------------
insert into unit(unitid,unitname)value(1,"个");
insert into unit(unitid,unitname)value(2,"斤");
insert into unit(unitid,unitname)value(3,"把");
insert into unit(unitid,unitname)value(4,"只");
insert into unit(unitid,unitname)value(5,"打");
insert into unit(unitid,unitname)value(6,"听");
insert into unit(unitid,unitname)value(7,"盒");
insert into unit(unitid,unitname)value(8,"台");
-- ----------------------------------------------------
-- class
-- ----------------------------------------------------
insert into class(classid,classname,fatherid,unitid)
value(1,'电器',0,8);
insert into class(classid,classname,fatherid,unitid)
value(2,'水果',0,2);
insert into class(classid,classname,fatherid,unitid)
value(3,'蔬菜',0,2);
insert into class(classid,classname,fatherid,unitid)
value(4,'日常用品',0,1);
insert into class(classid,classname,fatherid,unitid)
value(5,'日常用品',0,5);
 
-- ----------------------------------------------------
-- goods
-- ----------------------------------------------------
insert into goods(goodsname,goods_ecode,price,pic,shopid,last_refeash_user,classid) value('水杯','231231222',32.2,'sssss.jpg',1,1,4);
insert into goods(goodsname,goods_ecode,price,pic,shopid,last_refeash_user,classid) value('水杯','2312d23',30.2,'sssss.jpg',1,1,4);
insert into goods(goodsname,goods_ecode,price,pic,shopid,last_refeash_user,classid) value('水杯','23123232','23','sssss.jpg',1,1,4);
insert into goods(goodsname,goods_ecode,price,pic,shopid,last_refeash_user,classid) value('水杯','2f432','23','sssss.jpg',1,1,4);
insert into goods(goodsname,goods_ecode,price,pic,shopid,last_refeash_user,classid) value('水杯','654543','23','sssss.jpg',1,1,4);
insert into goods(goodsname,goods_ecode,price,pic,shopid,last_refeash_user,classid) value('水杯','23434','23','sssss.jpg',1,1,4);
insert into goods(goodsname,goods_ecode,price,pic,shopid,last_refeash_user,classid) value('水杯','231231222',31.2,'sssss.jpg',2,1,4);
insert into goods(goodsname,goods_ecode,price,pic,shopid,last_refeash_user,classid) value('水杯','2312d23',30.2,'sssss.jpg',2,1,4);
insert into goods(goodsname,goods_ecode,price,pic,shopid,last_refeash_user,classid) value('水杯','23123232',21,'sssss.jpg',2,1,4);
insert into goods(goodsname,goods_ecode,price,pic,shopid,last_refeash_user,classid) value('水杯','2f432',24,'sssss.jpg',2,1,4);
insert into goods(goodsname,goods_ecode,price,pic,shopid,last_refeash_user,classid) value('水杯','654543',43,'sssss.jpg',2,1,4);
insert into goods(goodsname,goods_ecode,price,pic,shopid,last_refeash_user,classid) value('水杯','23434',12,'sssss.jpg',2,1,4);

insert into goods(goodsname,goods_ecode,price,pic,shopid,last_refeash_user,classid) value('玻璃水杯','231231222',100.5,'sssss.jpg',1,1,4); 
insert into goods(goodsname,goods_ecode,price,pic,shopid,last_refeash_user,classid) value('玻璃水杯','231231222',99.9,'sssss.jpg',2,1,4); 
insert into goods(goodsname,goods_ecode,price,pic,shopid,last_refeash_user,classid) value('玻璃水杯','231231222',92.9,'sssss.jpg',3,1,4); 
insert into goods(goodsname,goods_ecode,price,pic,shopid,last_refeash_user,classid) value('玻璃水杯','231231222',95.9,'sssss.jpg',4,1,4); 
insert into goods(goodsname,goods_ecode,price,pic,shopid,last_refeash_user,classid) value('玻璃水杯','231231222',90.9,'sssss.jpg',5,1,4); 
insert into goods(goodsname,goods_ecode,price,pic,shopid,last_refeash_user,classid) value('玻璃水杯','231231222',100.9,'sssss.jpg',6,1,4); 
insert into goods(goodsname,goods_ecode,price,pic,shopid,last_refeash_user,classid) value('玻璃水杯','231231222',120,'sssss.jpg',7,1,4); 
insert into goods(goodsname,goods_ecode,price,pic,shopid,last_refeash_user,classid) value('玻璃水杯','231231222',99,'sssss.jpg',8,1,4); 

 

insert into goods(goodsname,goods_ecode,price,pic,shopid,last_refeash_user,classid) value('保温水杯','211111','56','sssss.jpg',1,1,4);
insert into goods(goodsname,goods_ecode,price,pic,shopid,last_refeash_user,classid) value('保温水杯','211111','56','sssss.jpg',2,1,4);
insert into goods(goodsname,goods_ecode,price,pic,shopid,last_refeash_user,classid) value('保温水杯','211111','56','sssss.jpg',3,1,4);
insert into goods(goodsname,goods_ecode,price,pic,shopid,last_refeash_user,classid) value('保温水杯','211111','56','sssss.jpg',4,1,4);
insert into goods(goodsname,goods_ecode,price,pic,shopid,last_refeash_user,classid) value('保温水杯','211111','56','sssss.jpg',5,1,4);
insert into goods(goodsname,goods_ecode,price,pic,shopid,last_refeash_user,classid) value('保温水杯','211111','56','sssss.jpg',6,1,4);
insert into goods(goodsname,goods_ecode,price,pic,shopid,last_refeash_user,classid) value('保温水杯','211111','56','sssss.jpg',7,1,4);


insert into goods(goodsname,goods_ecode,price,pic,shopid,last_refeash_user,classid) value('王牌电视机','2232321','5999','ss2sss.jpg',1,2,1);
insert into goods(goodsname,goods_ecode,price,pic,shopid,last_refeash_user,classid) value('王牌电视机','2232321','6800','ss2sss.jpg',2,2,1);
insert into goods(goodsname,goods_ecode,price,pic,shopid,last_refeash_user,classid) value('王牌电视机','2232321','6500','ss2sss.jpg',3,2,1);
insert into goods(goodsname,goods_ecode,price,pic,shopid,last_refeash_user,classid) value('王牌电视机','2232321','7000','ss2sss.jpg',4,2,1);
insert into goods(goodsname,goods_ecode,price,pic,shopid,last_refeash_user,classid) value('王牌电视机','2232321','7999','ss2sss.jpg',5,2,1);
insert into goods(goodsname,goods_ecode,price,pic,shopid,last_refeash_user,classid) value('王牌电视机','2232321','5678','ss2sss.jpg',6,2,1);
insert into goods(goodsname,goods_ecode,price,pic,shopid,last_refeash_user,classid) value('王牌电视机','2232321','6789','ss2sss.jpg',7,2,1);
insert into goods(goodsname,goods_ecode,price,pic,shopid,last_refeash_user,classid) value('苹果','234322',5.5,'sssss.jpg',1,3,2);
insert into goods(goodsname,goods_ecode,price,pic,shopid,last_refeash_user,classid) value('苹果','234322',4.5,'sssss.jpg',2,3,2);
insert into goods(goodsname,goods_ecode,price,pic,shopid,last_refeash_user,classid) value('苹果','234322',5.0,'sssss.jpg',3,3,2);
insert into goods(goodsname,goods_ecode,price,pic,shopid,last_refeash_user,classid) value('苹果','234322',4.6,'sssss.jpg',4,3,2);
insert into goods(goodsname,goods_ecode,price,pic,shopid,last_refeash_user,classid) value('苹果','234322',4.9,'sssss.jpg',5,3,2);
insert into goods(goodsname,goods_ecode,price,pic,shopid,last_refeash_user,classid) value('苹果','234322',4.3,'sssss.jpg',6,3,2);
insert into goods(goodsname,goods_ecode,price,pic,shopid,last_refeash_user,classid) value('苹果','234322',3.9,'sssss.jpg',7,3,2);

insert into goods(goodsname,goods_ecode,price,pic,shopid,last_refeash_user,classid) value('梨子','234234',4.4,'sssss.jpg',1,1,2);
insert into goods(goodsname,goods_ecode,price,pic,shopid,last_refeash_user,classid) value('梨子','234234',4.5,'sssss.jpg',2,1,2);
insert into goods(goodsname,goods_ecode,price,pic,shopid,last_refeash_user,classid) value('梨子','234234',2.5,'sssss.jpg',3,1,2);
insert into goods(goodsname,goods_ecode,price,pic,shopid,last_refeash_user,classid) value('梨子','234234',3,'sssss.jpg',4,1,2);
insert into goods(goodsname,goods_ecode,price,pic,shopid,last_refeash_user,classid) value('梨子','234234',3.2,'sssss.jpg',5,1,2);
insert into goods(goodsname,goods_ecode,price,pic,shopid,last_refeash_user,classid) value('梨子','234234',3.4,'sssss.jpg',6,1,2);
insert into goods(goodsname,goods_ecode,price,pic,shopid,last_refeash_user,classid) value('梨子','234234',5.0,'sssss.jpg',7,1,2);

insert into goods(goodsname,goods_ecode,price,pic,shopid,last_refeash_user,classid) value('黑人牙膏','d4322',10.2,'sssss.jpg',1,1,4);
insert into goods(goodsname,goods_ecode,price,pic,shopid,last_refeash_user,classid) value('黑人牙膏','d4322',5.5,'sssss.jpg',2,1,4);
insert into goods(goodsname,goods_ecode,price,pic,shopid,last_refeash_user,classid) value('黑人牙膏','d4322',2.3,'sssss.jpg',3,1,4);
insert into goods(goodsname,goods_ecode,price,pic,shopid,last_refeash_user,classid) value('黑人牙膏','d4322',2.5,'sssss.jpg',4,1,4);
insert into goods(goodsname,goods_ecode,price,pic,shopid,last_refeash_user,classid) value('黑人牙膏','d4322',9.9,'sssss.jpg',5,1,4);
insert into goods(goodsname,goods_ecode,price,pic,shopid,last_refeash_user,classid) value('黑人牙膏','d4322',9.8,'sssss.jpg',6,1,4);
insert into goods(goodsname,goods_ecode,price,pic,shopid,last_refeash_user,classid) value('黑人牙膏','d4322',5.5,'sssss.jpg',7,1,4);

insert into goods(goodsname,goods_ecode,price,pic,shopid,last_refeash_user,classid) value('大白菜','324',2.23,'sssss.jpg',1,1,3);
insert into goods(goodsname,goods_ecode,price,pic,shopid,last_refeash_user,classid) value('大白菜','324',4.3,'sssss.jpg',2,1,3);
insert into goods(goodsname,goods_ecode,price,pic,shopid,last_refeash_user,classid) value('大白菜','324',2.5,'sssss.jpg',3,1,3);
insert into goods(goodsname,goods_ecode,price,pic,shopid,last_refeash_user,classid) value('大白菜','324',2.8,'sssss.jpg',4,1,3);
insert into goods(goodsname,goods_ecode,price,pic,shopid,last_refeash_user,classid) value('大白菜','324',3.9,'sssss.jpg',5,1,3);
insert into goods(goodsname,goods_ecode,price,pic,shopid,last_refeash_user,classid) value('大白菜','324',3.2,'sssss.jpg',6,1,3);
insert into goods(goodsname,goods_ecode,price,pic,shopid,last_refeash_user,classid) value('大白菜','324',3.5,'sssss.jpg',7,1,3);

insert into goods(goodsname,goods_ecode,price,pic,shopid,last_refeash_user,classid) value('白萝卜','dsd222',2.2,'sssss.jpg',1,1,3);
insert into goods(goodsname,goods_ecode,price,pic,shopid,last_refeash_user,classid) value('白萝卜','dsd222',2.9,'sssss.jpg',2,1,3);
insert into goods(goodsname,goods_ecode,price,pic,shopid,last_refeash_user,classid) value('白萝卜','dsd222',1.0,'sssss.jpg',3,1,3);
insert into goods(goodsname,goods_ecode,price,pic,shopid,last_refeash_user,classid) value('白萝卜','dsd222',0.5,'sssss.jpg',4,1,3);
insert into goods(goodsname,goods_ecode,price,pic,shopid,last_refeash_user,classid) value('白萝卜','dsd222',2.3,'sssss.jpg',5,1,3);
insert into goods(goodsname,goods_ecode,price,pic,shopid,last_refeash_user,classid) value('白萝卜','dsd222',2.3,'sssss.jpg',6,1,3);
insert into goods(goodsname,goods_ecode,price,pic,shopid,last_refeash_user,classid) value('白萝卜','dsd222',2.5,'sssss.jpg',7,1,3);


