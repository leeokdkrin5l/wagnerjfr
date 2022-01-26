#### 项目介绍
CIM是基于mina和netty框架下的推送系统，我们平常使用第三方的推送SDK，如极光推送，百度推送，小米推送，以及腾讯信鸽等来支撑自己的移动端的业务，或许有一些用户自己实现即时通讯系统的需求，那么CIM为您提供了一个解决方案或者思路，目前CIM支撑 websocket，android，ios，桌面应用，系统应用等多端接入支持，目前CIM服务端使用springboot搭建仅仅拥有消息推送的功能，关于数据缓存与持久化都需要使用者自己开发，但是配备了比较完整的使用文档。最后希望CIM能为您带来一些价值。
   
---
## 相关项目
侣信专业版是基于CIM面向中小企业和者各类团队组织内部交流使用工具。具有丰富的功能，聊天，群组，部门组织，内部朋友圈等功能。它可以在局域网内使用保证沟通的信息安全，并且它是完全免费的，而且可以及时获得更新。
## [http://farsunset.com](http://farsunset.com)
<div align="center">
   <img src="https://images.gitee.com/uploads/images/2019/0403/110400_b83d0906_58912.jpeg" width="280px"  />
   <img src="https://images.gitee.com/uploads/images/2019/0403/110400_6883aa1b_58912.jpeg" width="280px" />
   <img src="https://images.gitee.com/uploads/images/2019/0403/110401_6d0679f4_58912.png" width="280px" />
</div>

---  

#### 目录说明

1. cim_for_mina目录下为mina版本实现
2. cim_for_netty目录下为netty版本实现
3. doc目录中是相关使用文档，以及protubuf结构体文件
5. cim-android-sdk 是android客户端封装的的jar包
6. cim-java-sdk 是java版客户端封装的的jar包
7. cim-server-sdk 是cim-boot-server 用到的封装的jar
8. cim-boot-server是springboot服务端工程，是intellij idea基于gradle构建
9. cim-client-android 是android客户端  android studio工具
10. 说明.txt是服务端环境搭建说明


#### 建议反馈

智者千虑必有一失，如果在使用或者学习过程中发现任何问题或者有优化建议，您可以通过QQ3979434或者邮箱3979434@qq.com向我反馈，当然目前还缺少IOS客户端sdk和.Net客户端SDK，如果您有兴趣可以参与开发，CIM将会越来越好。
 

#### 功能预览

1.控制台页面
![image](https://images.gitee.com/uploads/images/2019/0315/165050_9e269c1c_58912.png)
2.Android客户端
![image](https://images.gitee.com/uploads/images/2019/0315/165050_6f20f69e_58912.png)
3.Web客户端
![image](https://images.gitee.com/uploads/images/2019/0315/165050_dfc33c18_58912.png)


#### 更新日志
-------------------------------------------------------------------------------------------
版本:3.5.0/时间:2018-08-22

1.服务端由原来的 spring+struts2修改为springboot工程

2.全面重写websocket的实现，全面拥抱protobuf，替换json序列化方式，更加高效

-------------------------------------------------------------------------------------------
版本:3.6.0/时间:2019-04-17

1.服务端springboot升级2.1.4,protobuf升级3.7.0

2.android sdk升级，适配android8.0+，修复一些之前的兼容性问题

2.消息的id字段名由mid修改为id，类型由String修改为long;


 
 
 
 
