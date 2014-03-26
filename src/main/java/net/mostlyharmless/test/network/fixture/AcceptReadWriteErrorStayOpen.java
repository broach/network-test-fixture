/*
 * Copyright 2014 Brian Roach
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package net.mostlyharmless.test.network.fixture;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.WritableByteChannel;

/**
 *
 * @author Brian Roach <roach at basho dot com>
 */
public class AcceptReadWriteErrorStayOpen extends Acceptor
{
    public AcceptReadWriteErrorStayOpen(ServerSocketChannel server)
    {
        super(server);
    }
    
    @Override
    boolean writePb(SelectionKey key) throws IOException
    {
        ByteBuffer bb = ByteBuffer.allocate(pbErrorMsg.getSerializedSize() + 5);
        bb.putInt(pbErrorMsg.getSerializedSize() + 1);
        bb.put(pbErrorMsgCode);
        bb.put(pbErrorMsg.toByteArray());
        bb.flip();
        ((WritableByteChannel)key.channel()).write(bb);
        return false;
    }

    @Override
    Acceptor duplicate()
    {
        return new AcceptReadWriteErrorStayOpen(server);
    }
}
