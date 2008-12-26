/*
 * Copyright 2005-2008 the original author or authors.
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
package net.sf.dozer.functional_tests;

import net.sf.dozer.DataObjectInstantiator;
import net.sf.dozer.NoProxyDataObjectInstantiator;
import net.sf.dozer.vo.excluded.TwoA;
import net.sf.dozer.vo.excluded.TwoB;

/**
 * @author Dmitry Buzdin
 */
public class GrandparentTest extends AbstractMapperTest {

  protected void setUp() throws Exception {
    mapper = getMapper("grandparent.xml");
  }

  public void testParentProperty() {
    TwoA source = new TwoA();
    source.setId(new Integer(1));
        
    TwoB dest = (TwoB) mapper.map(source, TwoB.class);
    assertNotNull(dest);
    assertEquals(new Integer(1), dest.getId());
  }


  protected DataObjectInstantiator getDataObjectInstantiator() {
    return NoProxyDataObjectInstantiator.INSTANCE;
  }

}
