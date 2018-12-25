# jaxb-xjc-java11-test
Example code how to get code generation from XSD working in java11

It basically generating JAXB java classes from XSD by directly calling 
the XJCFacade class (from jaxb-xjc) instead of relying on the xjc util.
Update: It seems this first attempt didn't work out if you want to call this in a loop.
This is because of the calls that will exit current JVM.

However, it forwards its requests to the Driver class, which can be called directly as well.
This solves the problem of being able to call this multiple times.

As a side result this is much faster than calling the xjc util directly, since you
don't have the startup costs of the JVM for each call.
