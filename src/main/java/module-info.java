module com.dnlgby.skyhawk {
    requires spring.boot;
    requires spring.boot.autoconfigure;
    requires spring.context;
    requires spring.data.redis;
    requires jakarta.persistence;
    requires lombok;
    requires spring.data.jpa;
    requires spring.web;
    requires spring.data.commons;
    requires org.apache.tomcat.embed.core;
    exports com.dnlgby.skyhawk;
}