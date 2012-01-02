1. 将以下这句话复制到resin.conf中
   <host id="archetype.com">
		<resin:import path="conf/resin-datasource.xml" />
	</host>
	
2. 在host配置域名
   127.0.0.1  archetype.com
   
3. 将resin-datasource.xml文件复制到$(resin_home)/conf目录下