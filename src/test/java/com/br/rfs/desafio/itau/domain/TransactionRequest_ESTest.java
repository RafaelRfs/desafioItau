/*
 * This file was automatically generated by EvoSuite
 * Sun Aug 23 21:51:31 GMT 2020
 */

package com.br.rfs.desafio.itau.domain;

import org.junit.Test;
import static org.junit.Assert.*;
import com.br.rfs.desafio.itau.domain.TransactionRequest;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import org.evosuite.runtime.mock.java.time.MockLocalDateTime;

public class TransactionRequest_ESTest {

  @Test(timeout = 4000)
  public void test00()  throws Throwable  {
      TransactionRequest transactionRequest0 = new TransactionRequest();
      String string0 = transactionRequest0.toString();
      assertEquals("TransactionRequest(valor=null, dataHora=null)", string0);
  }

  @Test(timeout = 4000)
  public void test01()  throws Throwable  {
      TransactionRequest transactionRequest0 = new TransactionRequest();
      ZoneOffset zoneOffset0 = ZoneOffset.MAX;
      LocalDateTime localDateTime0 = MockLocalDateTime.now((ZoneId) zoneOffset0);
      transactionRequest0.setDataHora(localDateTime0);
      transactionRequest0.hashCode();
  }

  @Test(timeout = 4000)
  public void test02()  throws Throwable  {
      TransactionRequest transactionRequest0 = new TransactionRequest();
      BigDecimal bigDecimal0 = BigDecimal.ONE;
      transactionRequest0.setValor(bigDecimal0);
      transactionRequest0.hashCode();
  }

  @Test(timeout = 4000)
  public void test03()  throws Throwable  {
      TransactionRequest transactionRequest0 = new TransactionRequest();
      transactionRequest0.hashCode();
  }

  @Test(timeout = 4000)
  public void test04()  throws Throwable  {
      TransactionRequest transactionRequest0 = new TransactionRequest();
      ZoneOffset zoneOffset0 = ZoneOffset.MAX;
      LocalDateTime localDateTime0 = MockLocalDateTime.now((ZoneId) zoneOffset0);
      transactionRequest0.setDataHora(localDateTime0);
      TransactionRequest transactionRequest1 = new TransactionRequest();
      boolean boolean0 = transactionRequest0.equals(transactionRequest1);
      assertFalse(boolean0);
  }

  @Test(timeout = 4000)
  public void test05()  throws Throwable  {
      TransactionRequest transactionRequest0 = new TransactionRequest();
      Object object0 = new Object();
      boolean boolean0 = transactionRequest0.equals(object0);
      assertFalse(boolean0);
  }

  @Test(timeout = 4000)
  public void test06()  throws Throwable  {
      TransactionRequest transactionRequest0 = new TransactionRequest();
      BigDecimal bigDecimal0 = BigDecimal.ONE;
      transactionRequest0.setValor(bigDecimal0);
      TransactionRequest transactionRequest1 = new TransactionRequest();
      boolean boolean0 = transactionRequest0.equals(transactionRequest1);
      assertFalse(boolean0);
  }

  @Test(timeout = 4000)
  public void test07()  throws Throwable  {
      TransactionRequest transactionRequest0 = new TransactionRequest();
      TransactionRequest transactionRequest1 = new TransactionRequest();
      assertTrue(transactionRequest1.equals((Object)transactionRequest0));
      
      byte[] byteArray0 = new byte[1];
      BigInteger bigInteger0 = new BigInteger(byteArray0);
      BigDecimal bigDecimal0 = new BigDecimal(bigInteger0);
      transactionRequest1.setValor(bigDecimal0);
      boolean boolean0 = transactionRequest0.equals(transactionRequest1);
      assertFalse(transactionRequest1.equals((Object)transactionRequest0));
      assertFalse(boolean0);
  }

  @Test(timeout = 4000)
  public void test08()  throws Throwable  {
      TransactionRequest transactionRequest0 = new TransactionRequest();
      BigDecimal bigDecimal0 = BigDecimal.ONE;
      transactionRequest0.setValor(bigDecimal0);
      TransactionRequest transactionRequest1 = new TransactionRequest();
      assertFalse(transactionRequest1.equals((Object)transactionRequest0));
      
      transactionRequest1.setValor(bigDecimal0);
      boolean boolean0 = transactionRequest0.equals(transactionRequest1);
      assertTrue(transactionRequest1.equals((Object)transactionRequest0));
      assertTrue(boolean0);
  }

  @Test(timeout = 4000)
  public void test09()  throws Throwable  {
      TransactionRequest transactionRequest0 = new TransactionRequest();
      ZoneOffset zoneOffset0 = ZoneOffset.MAX;
      LocalDateTime localDateTime0 = MockLocalDateTime.now((ZoneId) zoneOffset0);
      transactionRequest0.setDataHora(localDateTime0);
      TransactionRequest transactionRequest1 = new TransactionRequest();
      assertFalse(transactionRequest1.equals((Object)transactionRequest0));
      
      transactionRequest1.setDataHora(localDateTime0);
      boolean boolean0 = transactionRequest0.equals(transactionRequest1);
      assertTrue(transactionRequest1.equals((Object)transactionRequest0));
      assertTrue(boolean0);
  }

  @Test(timeout = 4000)
  public void test10()  throws Throwable  {
      TransactionRequest transactionRequest0 = new TransactionRequest();
      BigDecimal bigDecimal0 = transactionRequest0.getValor();
      assertNull(bigDecimal0);
  }

  @Test(timeout = 4000)
  public void test11()  throws Throwable  {
      TransactionRequest transactionRequest0 = new TransactionRequest();
      LocalDateTime localDateTime0 = transactionRequest0.getDataHora();
      assertNull(localDateTime0);
  }

  @Test(timeout = 4000)
  public void test12()  throws Throwable  {
      TransactionRequest transactionRequest0 = new TransactionRequest();
      boolean boolean0 = transactionRequest0.canEqual("TransactionRequest(valor=null, dataHora=1970-01-01T18:00:00.179)");
      assertFalse(boolean0);
  }

  @Test(timeout = 4000)
  public void test13()  throws Throwable  {
      TransactionRequest transactionRequest0 = new TransactionRequest();
      boolean boolean0 = transactionRequest0.canEqual(transactionRequest0);
      assertTrue(boolean0);
  }

  @Test(timeout = 4000)
  public void test14()  throws Throwable  {
      TransactionRequest transactionRequest0 = new TransactionRequest();
      LocalDateTime localDateTime0 = MockLocalDateTime.now();
      transactionRequest0.setDataHora(localDateTime0);
      LocalDateTime localDateTime1 = transactionRequest0.getDataHora();
      assertSame(localDateTime1, localDateTime0);
  }

  @Test(timeout = 4000)
  public void test15()  throws Throwable  {
      TransactionRequest transactionRequest0 = new TransactionRequest();
      BigDecimal bigDecimal0 = new BigDecimal((-3128));
      transactionRequest0.setValor(bigDecimal0);
      BigDecimal bigDecimal1 = transactionRequest0.getValor();
      assertEquals((short) (-3128), bigDecimal1.shortValue());
  }

  @Test(timeout = 4000)
  public void test16()  throws Throwable  {
      TransactionRequest transactionRequest0 = new TransactionRequest();
      BigDecimal bigDecimal0 = BigDecimal.TEN;
      transactionRequest0.setValor(bigDecimal0);
      BigDecimal bigDecimal1 = transactionRequest0.getValor();
      assertSame(bigDecimal1, bigDecimal0);
  }

  @Test(timeout = 4000)
  public void test17()  throws Throwable  {
      TransactionRequest transactionRequest0 = new TransactionRequest();
      BigDecimal bigDecimal0 = BigDecimal.valueOf(1000000L, 835);
      transactionRequest0.setValor(bigDecimal0);
      BigDecimal bigDecimal1 = transactionRequest0.getValor();
      assertSame(bigDecimal1, bigDecimal0);
  }

  @Test(timeout = 4000)
  public void test18()  throws Throwable  {
      TransactionRequest transactionRequest0 = new TransactionRequest();
      boolean boolean0 = transactionRequest0.equals(transactionRequest0);
      assertTrue(boolean0);
  }
}