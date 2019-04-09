package com.lirui.boat;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * <p>
 * 启动类
 * </p>
 *
 * @author Li Rui
 * @since 2019-03-09
 */
@SpringBootApplication
@MapperScan("com.lirui.boat")
@Slf4j
public class BoatWebApplication {

  public static void main(String[] args) {
    SpringApplication.run(BoatWebApplication.class, args);
    log.info("============我启动了===========");
  }
}