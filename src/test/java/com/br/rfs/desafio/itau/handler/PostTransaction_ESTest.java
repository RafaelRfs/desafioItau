/*
 * This file was automatically generated by EvoSuite
 * Sun Aug 23 21:59:57 GMT 2020
 */

package com.br.rfs.desafio.itau.handler;

import org.junit.Test;
import static org.junit.Assert.*;
import com.br.rfs.desafio.itau.domain.DesafioResponse;
import com.br.rfs.desafio.itau.domain.TransactionRequest;
import com.br.rfs.desafio.itau.handler.PostTransaction;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.ChannelOutboundHandlerAdapter;
import io.netty.channel.CombinedChannelDuplexHandler;
import java.time.Clock;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.chrono.ThaiBuddhistEra;
import java.util.Stack;
import java.util.Vector;
import org.evosuite.runtime.System;
import org.evosuite.runtime.mock.java.time.MockClock;
import org.evosuite.runtime.mock.java.time.MockLocalDateTime;

public class PostTransaction_ESTest {

  @Test(timeout = 4000)
  public void test0()  throws Throwable  {
      PostTransaction postTransaction0 = new PostTransaction();
      DesafioResponse<Integer> desafioResponse0 = new DesafioResponse<Integer>();
      Vector<TransactionRequest> vector0 = new Vector<TransactionRequest>();
      ThaiBuddhistEra thaiBuddhistEra0 = ThaiBuddhistEra.BE;
      postTransaction0.run(desafioResponse0, thaiBuddhistEra0, (Object) null, vector0);
      assertTrue(vector0.isEmpty());
  }

  @Test(timeout = 4000)
  public void test1()  throws Throwable  {
      PostTransaction postTransaction0 = new PostTransaction();
      DesafioResponse<Integer> desafioResponse0 = new DesafioResponse<Integer>();
      Stack<TransactionRequest> stack0 = new Stack<TransactionRequest>();
      TransactionRequest transactionRequest0 = new TransactionRequest();
      ZoneOffset zoneOffset0 = ZoneOffset.ofHoursMinutes(1, 1);
      LocalDateTime localDateTime0 = MockLocalDateTime.ofEpochSecond(2504L, 1, zoneOffset0);
      transactionRequest0.setDataHora(localDateTime0);
      // Undeclared exception!
      try { 
        postTransaction0.run(desafioResponse0, transactionRequest0, stack0, stack0);
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
         //
         // no message in exception (getMessage() returned null)
         //
      }
  }

  @Test(timeout = 4000)
  public void test2()  throws Throwable  {
      PostTransaction postTransaction0 = new PostTransaction();
      DesafioResponse<Integer> desafioResponse0 = new DesafioResponse<Integer>();
      ChannelInboundHandlerAdapter channelInboundHandlerAdapter0 = new ChannelInboundHandlerAdapter();
      Vector<TransactionRequest> vector0 = new Vector<TransactionRequest>();
      TransactionRequest transactionRequest0 = new TransactionRequest();
      Clock clock0 = MockClock.systemDefaultZone();
      LocalDateTime localDateTime0 = MockLocalDateTime.now(clock0);
      transactionRequest0.setDataHora(localDateTime0);
      ChannelOutboundHandlerAdapter channelOutboundHandlerAdapter0 = new ChannelOutboundHandlerAdapter();
      CombinedChannelDuplexHandler<ChannelInboundHandlerAdapter, ChannelOutboundHandlerAdapter> combinedChannelDuplexHandler0 = new CombinedChannelDuplexHandler<ChannelInboundHandlerAdapter, ChannelOutboundHandlerAdapter>(channelInboundHandlerAdapter0, channelOutboundHandlerAdapter0);
      System.setCurrentTimeMillis(0L);
      try { 
        postTransaction0.run(desafioResponse0, transactionRequest0, combinedChannelDuplexHandler0, vector0);
        fail("Expecting exception: Exception");
      
      } catch(Exception e) {
         //
         // Data da transa\u00E7\u00E3o n\u00E3o permitida
         //
      }
  }
}
