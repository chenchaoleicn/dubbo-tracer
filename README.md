# dubbo-tracer
### dubbo traceId工具包，基于dubbo2.5.3~2.6.x，包括traceId的设置、获取、传递
关于链路追踪，在微服务的趋势下，一次调用的日志信息分布在不同的机器上或目录下，
当需要看一条链路调用所有的日志信息时，比较困难，我们虽然有ELK、Sentry等日志收集分析工具，但是如何把信息串起来也是一个关键的问题。
我们一般的做法是在系统调用开始时生成一个traceId， 并且它伴随着一次调用的整个生命周期。 
当一个服务调用另外一个服务的时候，traceId则向下透传，全局使用唯一一个。

参考链接
- 【dubbo官网-SPI机制】 http://dubbo.apache.org/zh-cn/docs/source_code_guide/dubbo-spi.html
- 【dubbo官网-调用拦截扩展】 http://dubbo.apache.org/zh-cn/docs/dev/impls/filter.html
- 【dubbo官网-扩展点重构】 http://dubbo.apache.org/zh-cn/docs/dev/principals/extension.html
- 【Log4j2中文文档2.x-ThreadContext】 http://dubbo.apache.org/zh-cn/docs/dev/principals/extension.html