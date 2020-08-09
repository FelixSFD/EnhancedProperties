/*
 * Copyright (c) 2020 FelixSFD
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package de.felixsfd.EnhancedProperties.core;

import org.jetbrains.annotations.NotNull;

import java.util.*;

/**
 * Wraps the default {@link Properties} class to sort the keys
 * <br>
 * Thanks to <a href="https://stackoverflow.com/users/3681607/smillien62">smillien62</a>
 * on <a href="https://stackoverflow.com/a/52127284/4687348">Stack Overflow</a>!
 *
 * @since 1.1.0
 * @author <a href="https://stackoverflow.com/users/3681607/smillien62">smillien62</a>
 */
public class SortedProperties extends Properties {
  @Override
  public @NotNull Set<Object> keySet() {
    return Collections.unmodifiableSet(new TreeSet<>(super.keySet()));
  }

  @Override
  public @NotNull Set<Map.Entry<Object, Object>> entrySet() {

    Set<Map.Entry<Object, Object>> set1 = super.entrySet();
    Set<Map.Entry<Object, Object>> set2 = new LinkedHashSet<>(set1.size());

    Iterator<Map.Entry<Object, Object>> iterator = set1.stream().sorted(Comparator.comparing(o -> o.getKey().toString())).iterator();

    while (iterator.hasNext())
      set2.add(iterator.next());

    return set2;
  }

  @Override
  public synchronized Enumeration<Object> keys() {
    return Collections.enumeration(new TreeSet<>(super.keySet()));
  }
}
