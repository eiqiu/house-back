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
登陆、注册模块、用户房屋管理模块、收藏模块、搜索模块。
```

# 3、版本要求

```xml
前端：vue-cli 5.0.4、node.js  16.13.2

后端：mysql 8.0.28 、jdk1.8
```

# 4、项目部署

**前端**

**下载相关依赖**

```xml
npm install
```

**运行**

```xml
npm run serve
```

**后端**

**修改 JDK 版本**

```xml
<properties>
		<java.version>1.8</java.version>
</properties>
```

**修改图片保存路径**

```java
public class ImageServiceImpl implements ImageService {
    // 文件保存的路径
    // 此处修改为自己的项目的static路径
	private String uploaddir = "F:\\桌面\\BackAndFront\\house-back\\src\\main\\resources\\static";
}
```

