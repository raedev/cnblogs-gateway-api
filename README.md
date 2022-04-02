# 博客园客户端接口

[博客园Android 客户端](https://github.com/raedev/android-cnblogs) 网关接口，基于`Spring Boot`框架开发。

## 接口说明

> 返回格式说明

接口请求成功，直接返回数据，示例：

```json
{
  "downloadUrl": "https://cnblogs.com/download/a.apk",
  "versionName": "1.0.0",
  "versionCode": 1
}
```

失败返回错误信息，示例：

```json
{
  "timestamp": "2022-03-21T03:40:17.007+00:00",
  "status": 403,
  "error": "Forbidden",
  "message": "非法请求",
  "path": "/app/config"
}
```
