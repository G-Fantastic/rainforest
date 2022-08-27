package com.iofairy.test;

import com.iofairy.rainforest.zip.ArchiveFormat;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author GG
 * @version 1.0
 * @date 2022/8/27 21:17
 */
public class ArchiveFormatTest {
    @Test
    void testOf() {
        ArchiveFormat af01 = ArchiveFormat.of("Z");
        ArchiveFormat af02 = ArchiveFormat.of(".Z");
        ArchiveFormat af03 = ArchiveFormat.of("tar.Z");
        ArchiveFormat af04 = ArchiveFormat.of("tar.gZ");
        ArchiveFormat af05 = ArchiveFormat.of(".tar.gZ");
        ArchiveFormat af06 = ArchiveFormat.of(".csv");
        ArchiveFormat af07 = ArchiveFormat.of("TXT");
        ArchiveFormat af08 = ArchiveFormat.of("GZ");
        ArchiveFormat af09 = ArchiveFormat.of(null);
        ArchiveFormat af10 = ArchiveFormat.of("");
        ArchiveFormat af11 = ArchiveFormat.of("z");
        ArchiveFormat af12 = ArchiveFormat.of(".z");
        ArchiveFormat af13 = ArchiveFormat.of("zip");
        ArchiveFormat af14 = ArchiveFormat.of("tar.z");
        ArchiveFormat af15 = ArchiveFormat.of("TBZ2");

        assertEquals(ArchiveFormat.Z_COMPRESS, af01);
        assertEquals(ArchiveFormat.Z_COMPRESS, af02);
        assertEquals(ArchiveFormat.TAR_Z, af03);
        assertEquals(ArchiveFormat.TAR_GZ, af04);
        assertEquals(ArchiveFormat.TAR_GZ, af05);
        assertNull(af06);
        assertNull(af07);
        assertEquals(ArchiveFormat.GZIP, af08);
        assertNull(af09);
        assertNull(af10);
        assertEquals(ArchiveFormat.Z_PACK, af11);
        assertEquals(ArchiveFormat.Z_PACK, af12);
        assertEquals(ArchiveFormat.ZIP, af13);
        assertEquals(ArchiveFormat.TAR_Z, af14);
        assertEquals(ArchiveFormat.TBZ2, af15);
    }
}
