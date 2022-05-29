# <center>馨家租房</center>

# 1、技术栈

## 1、1前端技术栈：

```xml
Vue.js 2.6、Vue-Router、 Vuex、Element UI、axios、vue-markdown。
```

## 1、2后端技术栈：

```xml
Springboot、Spring、Mybatis。
```

## 1、3数据库及管理工具：

```xml
MySQL、Navicat for MySQL。
```

# 2、主要功能

```xml
用户端：登陆、注册模块、用户房屋管理模块、收藏模块、搜索模块、热门模块、消息模块
管理员端：登陆、用户管理模块、房屋管理模块
```

# 3、版本要求

```xml
前端：vue-cli:5.0.4、node.js:16.13.2

后端：mysql:8.0.28 、jdk:1.8
```

# 4、项目部署

**前端（用户端+管理员端）**

端口：用户端口号：8088 管理员端口号：8087

**1、下载相关依赖**

```xml
npm install
```

**2、运行**

```xml
npm run serve
```

**后端** 端口号：8089

**1、修改 JDK 版本**

```xml
<properties>
	<java.version>1.8</java.version>
</properties>
```

**2、修改图片保存路径**

```java
public class ImageServiceImpl implements ImageService {
    // 文件保存的路径
    // 此处修改为自己的项目的static所在路径
	private String uploaddir = "F:\\桌面\\BackAndFront\\house-back\\src\\main\\resources\\static";
}
```

# 5、需求文档

<a href="https://www.kdocs.cn/l/cvaSTq1G9xnB">点此跳转至在线文档</a>
