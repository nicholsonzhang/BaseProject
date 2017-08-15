compile 'com.squareup:javapoet:1.9.0'

此依赖用于生成java代码

compile 'com.google.auto.service:auto-service:1.0-rc3'

此依赖用于声明注解处理器，使用方式是在注解处理器的头部添加
@AutoService(Processor.class)