/**
 * The MIT License
 *
 *   Copyright (c) 2017, Mahmoud Ben Hassine (mahmoud.benhassine@icloud.com)
 *
 *   Permission is hereby granted, free of charge, to any person obtaining a copy
 *   of this software and associated documentation files (the "Software"), to deal
 *   in the Software without restriction, including without limitation the rights
 *   to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 *   copies of the Software, and to permit persons to whom the Software is
 *   furnished to do so, subject to the following conditions:
 *
 *   The above copyright notice and this permission notice shall be included in
 *   all copies or substantial portions of the Software.
 *
 *   THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 *   IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 *   FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 *   AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 *   LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 *   OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 *   THE SOFTWARE.
 */
package io.github.benas.randombeans.parameters;

import io.github.benas.randombeans.api.EnhancedRandom;
import io.github.benas.randombeans.beans.TimeBean;
import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalTime;

import static io.github.benas.randombeans.EnhancedRandomBuilder.aNewEnhancedRandomBuilder;
import static org.assertj.core.api.Assertions.assertThat;

public class DateTimeRangeParameterTests {

    @Test
    public void testDateRange() {
        // Given
        LocalDate minDate = LocalDate.of(2016, 1, 1);
        LocalDate maxDate = LocalDate.of(2016, 1, 31);
        EnhancedRandom enhancedRandom = aNewEnhancedRandomBuilder().dateRange(minDate, maxDate).build();

        // When
        TimeBean timeBean = enhancedRandom.nextObject(TimeBean.class);

        // Then
        assertThat(timeBean.getLocalDate()).isAfterOrEqualTo(minDate).isBeforeOrEqualTo(maxDate);
    }

    @Test
    public void testTimeRange() {
        // Given
        LocalTime minTime = LocalTime.of(15, 0, 0);
        LocalTime maxTime = LocalTime.of(18, 0, 0);
        EnhancedRandom enhancedRandom = aNewEnhancedRandomBuilder().timeRange(minTime, maxTime).build();

        // When
        TimeBean timeBean = enhancedRandom.nextObject(TimeBean.class);

        // Then
        assertThat(timeBean.getLocalTime()).isAfterOrEqualTo(minTime).isBeforeOrEqualTo(maxTime);
    }
}
