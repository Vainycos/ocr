1.关于页面的内容我都放在resource/static下,其中ocr.html中依赖jQuery、imgFileupload来实现上传图片，使用layer.js实现解析等待过程中的遮层

   使用了layer.css和ocr.css的样式



2.使用了SpringBoot的微服务架构，只有一个/ocr/go的图片识别接口映射服务，无其他任何内容

   默认使用了8080端口

   丢到服务器上，使用命令:nohup java -jar ocr-0.0.1-SNAPSHOT.jar &

   该服务就已经启动，对外暴露访问接口:ip+port+"/orc/go",使用post请求，接受一个base64Url参数



3.ocr.html中的发送请求地址目前是个人地址，若使用了第二步部署了自己的服务，可以修改第37行的url地址，其他不变