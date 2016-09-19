/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.spark.network.buffer.nio;

import java.nio.ByteBuffer;

import org.apache.spark.network.buffer.ChunkedByteBuffer;

public class DerivedChunkedByteBuffer extends ChunkedByteBufferImpl {

  final ChunkedByteBuffer unwrap;

  public DerivedChunkedByteBuffer(ByteBuffer[] chunks, ChunkedByteBuffer unwrap) {
    super(chunks);
    this.unwrap = unwrap;
  }

  @Override
  public int refCnt() {
    return unwrap.refCnt();
  }

  @Override
  public DerivedChunkedByteBuffer retain() {
    unwrap.retain();
    return this;
  }

  @Override
  public DerivedChunkedByteBuffer retain(int increment) {
    unwrap.retain();
    return this;
  }

  @Override
  public boolean release() {
    return unwrap.release();
  }

  @Override
  public boolean release(int decrement) {
    return unwrap.release();
  }
}
