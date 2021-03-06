/*
 * Copyright 2013 Brian Roach
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
import java.nio.channels.SelectionKey;
import java.nio.channels.ServerSocketChannel;

/**
 *
 * @author Brian Roach <roach at mostlyharmless dot net>
 */
public class Shutdown extends Acceptor
{

    public Shutdown(ServerSocketChannel server)
    {
        super(server);
        this.type = AcceptorType.SHUTDOWN;
    }

    @Override
    Acceptor duplicate()
    {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    boolean writePb(SelectionKey key) throws IOException
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
