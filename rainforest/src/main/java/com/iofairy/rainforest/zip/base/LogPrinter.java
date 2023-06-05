/*
 * Copyright (C) 2021 iofairy, <https://github.com/iofairy/rainforest>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.iofairy.rainforest.zip.base;

import com.iofairy.rainforest.zip.utils.StringKit;
import lombok.extern.slf4j.Slf4j;

/**
 * SuperCompressor日志打印控制
 *
 * @since 0.2.0
 */
@Slf4j
public class LogPrinter {
    private static final int REPEAT_FACTOR = 5;
    private static final int MAX_REPEAT_TIMES = 6;

    public static void logs(String format, Object... arguments) {
        log.info(format, arguments);
    }

    public static void printBeforeUnzip(String unzipId, String zipFileName, ZipLogLevel zipLogLevel, String logSource) {
        if (zipLogLevel.level >= ZipLogLevel.BRIEF.level) {
            logs(">*>*>*>*>*>*>*>*>*>*>*>*>*>*>*>*>*>*>*> 解压ID：[{}]，压缩包【{}】正在处理…… <<{}>>", unzipId, zipFileName, logSource);
        }
    }

    public static void printAfterUnzip(String unzipId, String zipFileName, ZipLogLevel zipLogLevel, String logSource, long startTime) {
        if (zipLogLevel.level >= ZipLogLevel.BRIEF.level) {
            logs("<*<*<*<*<*<*<*<*<*<*<*<*<*<*<*<*<*<*<*< 解压ID：[{}]，压缩包【{}】完成处理！耗时：【{}】 <<{}>>", unzipId, zipFileName, (System.currentTimeMillis() - startTime), logSource);
        }
    }

    public static void printBeforeUnzip(String unzipId, int unzipTimes, String zipFileName, String entryFileName, ZipLogLevel zipLogLevel, String logSource) {
        if (zipLogLevel.level >= ZipLogLevel.BRIEF.level) {
            String repeat = StringKit.repeat(">", Math.max(MAX_REPEAT_TIMES - unzipTimes, 1) * REPEAT_FACTOR);
            logs("{} 解压ID：[{}]，当前unzipTimes为：[{}]，正在解压【{}】中的压缩包【{}】…… <<{}>>", repeat, unzipId, unzipTimes, zipFileName, entryFileName, logSource);
        }
    }

    public static void printAfterUnzip(String unzipId, int unzipTimes, String zipFileName, String entryFileName, ZipLogLevel zipLogLevel, String logSource, long startTime) {
        if (zipLogLevel.level >= ZipLogLevel.BRIEF.level) {
            String repeat = StringKit.repeat("<", Math.max(MAX_REPEAT_TIMES - unzipTimes, 1) * REPEAT_FACTOR);
            logs("{} 解压ID：[{}]，当前unzipTimes为：[{}]，完成解压【{}】中的压缩包【{}】！耗时：【{}】 <<{}>>", repeat, unzipId, unzipTimes, zipFileName, entryFileName, (System.currentTimeMillis() - startTime), logSource);
        }
    }

    public static void printBeforeOther(String unzipId, int unzipTimes, String zipFileName, String entryFileName, ZipLogLevel zipLogLevel, String logSource) {
        if (zipLogLevel.level >= ZipLogLevel.DETAIL.level) {
            String repeat = StringKit.repeat("(", Math.max(MAX_REPEAT_TIMES - unzipTimes, 1) * REPEAT_FACTOR);
            logs("{} 解压ID：[{}]，当前unzipTimes为：[{}]，正在处理【{}】中的文件【{}】…… <<{}>>", repeat, unzipId, unzipTimes, zipFileName, entryFileName, logSource);
        }
    }

    public static void printAfterOther(String unzipId, int unzipTimes, String zipFileName, String entryFileName, ZipLogLevel zipLogLevel, String logSource, long startTime) {
        if (zipLogLevel.level >= ZipLogLevel.DETAIL.level) {
            String repeat = StringKit.repeat(")", Math.max(MAX_REPEAT_TIMES - unzipTimes, 1) * REPEAT_FACTOR);
            logs("{} 解压ID：[{}]，当前unzipTimes为：[{}]，完成处理【{}】中的文件【{}】！耗时：【{}】 <<{}>>", repeat, unzipId, unzipTimes, zipFileName, entryFileName, (System.currentTimeMillis() - startTime), logSource);
        }
    }

    public static void printDeleteLogs(String unzipId, int unzipTimes, String zipFileName, String entryFileName, ZipLogLevel zipLogLevel, String logSource) {
        if (zipLogLevel.level >= ZipLogLevel.DETAIL.level) {
            String repeat = StringKit.repeat("-", Math.max(MAX_REPEAT_TIMES - unzipTimes, 1) * REPEAT_FACTOR);
            logs("{} 解压ID：[{}]，当前unzipTimes为：[{}]，正在删除【{}】中的文件【{}】…… <<{}>>", repeat, unzipId, unzipTimes, zipFileName, entryFileName, logSource);
        }
    }

    public static void printAppendLogs(String unzipId, int unzipTimes, String zipFileName, String entryFileName, ZipLogLevel zipLogLevel, String logSource) {
        if (zipLogLevel.level >= ZipLogLevel.DETAIL.level) {
            String repeat = StringKit.repeat("+", Math.max(MAX_REPEAT_TIMES - unzipTimes, 1) * REPEAT_FACTOR);
            logs("{} 解压ID：[{}]，当前unzipTimes为：[{}]，正在向【{}】中添加文件【{}】…… <<{}>>", repeat, unzipId, unzipTimes, zipFileName, entryFileName, logSource);
        }
    }

    public static void printFilterLogs(String unzipId, int unzipTimes, String zipFileName, String entryFileName, ZipLogLevel zipLogLevel, String logSource) {
        if (zipLogLevel.level >= ZipLogLevel.DETAIL.level) {
            String repeat = StringKit.repeat("#", Math.max(MAX_REPEAT_TIMES - unzipTimes, 1) * REPEAT_FACTOR);
            logs("{} 解压ID：[{}]，当前unzipTimes为：[{}]，不处理【{}】中【{}】的文件！ <<{}>>", repeat, unzipId, unzipTimes, zipFileName, entryFileName, logSource);
        }
    }

    public static void printDeleteActionLogs(String unzipId, int unzipTimes, String zipFileName, String entryFileName, ZipLogLevel zipLogLevel, String logSource) {
        if (zipLogLevel.level >= ZipLogLevel.ALL.level) {
            String repeat = StringKit.repeat("=", Math.max(MAX_REPEAT_TIMES - unzipTimes, 1) * REPEAT_FACTOR);
            logs("{} 解压ID：[{}]，当前unzipTimes为：[{}]，删除前处理【{}】中的文件【{}】…… <<{}>>", repeat, unzipId, unzipTimes, zipFileName, entryFileName, logSource);
        }
    }

    public static void printBeforeAfter(String unzipId, int unzipTimes, String zipFileName, String entryFileName, ZipLogLevel zipLogLevel, String logSource, String extMsg) {
        if (zipLogLevel.level >= ZipLogLevel.ALL.level) {
            String repeat = StringKit.repeat("&", Math.max(MAX_REPEAT_TIMES - unzipTimes, 1) * REPEAT_FACTOR);
            logs("{} 解压ID：[{}]，当前unzipTimes为：[{}]，【{}】中的压缩包【{}】解压缩[{}]处理！ <<{}>>", repeat, unzipId, unzipTimes, zipFileName, entryFileName, extMsg, logSource);
        }
    }


}
