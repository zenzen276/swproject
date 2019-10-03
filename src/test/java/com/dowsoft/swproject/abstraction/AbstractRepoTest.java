package com.dowsoft.swproject.abstraction;

import static com.wix.mysql.distribution.Version.v5_7_19;
import java.time.ZoneId;
import java.util.TimeZone;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import com.wix.mysql.EmbeddedMysql;
import com.wix.mysql.config.MysqldConfig;
import com.wix.mysql.config.SchemaConfig;

public abstract class AbstractRepoTest {

  private static EmbeddedMysql embeddedMysql;
  
  protected final String sqlpath = "classpath:scripts/";

  @BeforeClass
  public static void init() throws InterruptedException {

    MysqldConfig config = MysqldConfig.aMysqldConfig(v5_7_19).withPort(3306)
        .withTimeZone(TimeZone.getTimeZone(ZoneId.of("UTC"))).withUser("test", "test").build();

    SchemaConfig schemaConfig = SchemaConfig.aSchemaConfig("test").build();

    embeddedMysql = EmbeddedMysql.anEmbeddedMysql(config).addSchema(schemaConfig).start();
  }

  @Test
  public void contextLoads() {}

  @AfterClass
  public static void _tearDownAfterClass() {
    if (null != embeddedMysql) {
      embeddedMysql.stop();
    }
  }

}
