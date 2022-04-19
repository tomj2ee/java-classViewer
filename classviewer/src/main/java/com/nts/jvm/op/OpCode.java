package com.nts.jvm.op;

public enum OpCode {

    NOP(0, 0x00, 0, "nop"),
    ACONST_NULL(1, 0x01, 0, "aconst_null"),
    ICONST_M1(2, 0x02, 0, "iconst_m1"),
    ICONST_0(3, 0x03, 0, "iconst_0"),
    ICONST_1(4, 0x04, 0, "iconst_1"),
    ICONST_2(5, 0x05, 0, "iconst_2"),
    ICONST_3(6, 0x06, 0, "iconst_3"),
    ICONST_4(7, 0x07, 0, "iconst_4"),
    ICONST_5(8, 0x08, 0, "iconst_5"),
    LCONST_0(9, 0x09, 0, "lconst_0"),
    LCONST_1(10, 0x0a, 0, "lconst_1"),
    FCONST_0(11, 0x0b, 0, "fconst_0"),
    FCONST_1(12, 0x0c, 0, "fconst_1"),
    FCONST_2(13, 0x0d, 0, "fconst_2"),
    DCONST_0(14, 0x0e, 0, "dconst_0"),
    DCONST_1(15, 0x0f, 0, "dconst_1"),
    BIPUSH(16, 0x10, 1, "bipush"),
    SIPUSH(17, 0x11, 1, "sipush"),
    LDC(18, 0x12, 1, "ldc"),
    LDC_W(19, 0x13, 1, "ldc_w"),
    LDC2_W(20, 0x14, 2, "ldc2_w"),
    ILOAD(21, 0x15, 1, "iload"),
    LLOAD(22, 0x16, 1, "lload"),
    FLOAD(23, 0x17, 1, "fload"),
    DLOAD(24, 0x18, 1, "dload"),
    ALOAD(25, 0x19, 1, "aload"),
    ILOAD_0(26, 0x1a, 0, "iload_0"),
    ILOAD_1(27, 0x1b, 0, "iload_1"),
    ILOAD_2(28, 0x1c, 0, "iload_2"),
    ILOAD_3(29, 0x1d, 0, "iload_3"),
    LLOAD_0(30, 0x1e, 0, "lload_0"),
    LLOAD_1(31, 0x1f, 0, "lload_1"),
    LLOAD_2(32, 0x20, 0, "lload_2"),
    LLOAD_3(33, 0x21, 0, "lload_3"),
    FLOAD_0(34, 0x22, 0, "fload_0"),
    FLOAD_1(35, 0x23, 0, "fload_1"),
    FLOAD_2(36, 0x24, 0, "fload_2"),
    FLOAD_3(37, 0x25, 0, "fload_3"),
    DLOAD_0(38, 0x26, 0, "dload_0"),
    DLOAD_1(39, 0x27, 0, "dload_1"),
    DLOAD_2(40, 0x28, 0, "dload_2"),
    DLOAD_3(41, 0x29, 0, "dload_3"),
    ALOAD_0(42, 0x2a, 0, "aload_0"),
    ALOAD_1(43, 0x2b, 0, "aload_1"),
    ALOAD_2(44, 0x2c, 0, "aload_2"),
    ALOAD_3(45, 0x2d, 0, "aload_3"),
    IALOAD(46, 0x2e, 1, "iaload"),
    LALOAD(47, 0x2f, 1, "laload"),
    FALOAD(48, 0x30, 1, "faload"),
    DALOAD(49, 0x31, 1, "daload"),
    AALOAD(50, 0x32, 1, "aaload"),
    BALOAD(51, 0x33, 1, "baload"),
    CALOAD(52, 0x34, 1, "caload"),
    SALOAD(53, 0x35, 1, "saload"),
    ISTORE(54, 0x36, 1, "istore"),
    LSTORE(55, 0x37, 1, "lstore"),
    FSTORE(56, 0x38, 1, "fstore"),
    DSTORE(57, 0x39, 1, "dstore"),
    ASTORE(58, 0x3a, 1, "astore"),
    ISTORE_0(59, 0x3b, 0, "istore_0"),
    ISTORE_1(60, 0x3c, 0, "istore_1"),
    ISTORE_2(61, 0x3d, 0, "istore_2"),
    ISTORE_3(62, 0x3e, 0, "istore_3"),
    LSTORE_0(63, 0x3f, 0, "lstore_0"),
    LSTORE_1(64, 0x40, 0, "lstore_1"),
    LSTORE_2(65, 0x41, 0, "lstore_2"),
    LSTORE_3(66, 0x42, 0, "lstore_3"),
    FSTORE_0(67, 0x43, 0, "fstore_0"),
    FSTORE_1(68, 0x44, 0, "fstore_1"),
    FSTORE_2(69, 0x45, 0, "fstore_2"),
    FSTORE_3(70, 0x46, 0, "fstore_3"),
    DSTORE_0(71, 0x47, 0, "dstore_0"),
    DSTORE_1(72, 0x48, 0, "dstore_1"),
    DSTORE_2(73, 0x49, 0, "dstore_2"),
    DSTORE_3(74, 0x4a, 0, "dstore_3"),
    ASTORE_0(75, 0x4b, 0, "astore_0"),
    ASTORE_1(76, 0x4c, 0, "astore_1"),
    ASTORE_2(77, 0x4d, 0, "astore_2"),
    ASTORE_3(78, 0x4e, 0, "astore_3"),
    IASTORE(79, 0x4f, 0, "iastore"),
    LASTORE(80, 0x50, 0, "lastore"),
    FASTORE(81, 0x51, 0, "fastore"),
    DASTORE(82, 0x52, 0, "dastore"),
    AASTORE(83, 0x53, 0, "aastore"),
    BASTORE(84, 0x54, 0, "bastore"),
    CASTORE(85, 0x55, 0, "castore"),
    SASTORE(86, 0x56, 0, "sastore"),
    POP(87, 0x57, 0, "pop"),
    POP2(88, 0x58, 0, "pop2"),
    DUP(89, 0x59, 0, "dup"),
    DUP_X1(90, 0x5a, 0, "dup_x1"),
    DUP_X2(91, 0x5b, 0, "dup_x2"),
    DUP2(92, 0x5c, 0, "dup2"),
    DUP2_X1(93, 0x5d, 0, "dup2_x1"),
    DUP2_X2(94, 0x5e, 0, "dup2_x2"),
    SWAP(95, 0x5f, 0, "swap"),
    IADD(96, 0x60, 0, "iadd"),
    LADD(97, 0x61, 0, "ladd"),
    FADD(98, 0x62, 0, "fadd"),
    DADD(99, 0x63, 0, "dadd"),
    ISUB(100, 0x64, 0, "isub"),
    LSUB(101, 0x65, 0, "lsub"),
    FSUB(102, 0x66, 0, "fsub"),
    DSUB(103, 0x67, 0, "dsub"),
    IMUL(104, 0x68, 0, "imul"),
    LMUL(105, 0x69, 0, "lmul"),
    FMUL(106, 0x6a, 0, "fmul"),
    DMUL(107, 0x6b, 0, "dmul"),
    IDIV(108, 0x6c, 0, "idiv"),
    LDIV(109, 0x6d, 0, "ldiv"),
    FDIV(110, 0x6e, 0, "fdiv"),
    DDIV(111, 0x6f, 0, "ddiv"),
    IREM(112, 0x70, 0, "irem"),
    LREM(113, 0x71, 0, "lrem"),
    FREM(114, 0x72, 0, "frem"),
    DREM(115, 0x73, 0, "drem"),
    INEG(116, 0x74, 0, "ineg"),
    LNEG(117, 0x75, 0, "lneg"),
    FNEG(118, 0x76, 0, "fneg"),
    DNEG(119, 0x77, 0, "dneg"),
    ISHL(120, 0x78, 0, "ishl"),
    LSHL(121, 0x79, 0, "lshl"),
    ISHR(122, 0x7a, 0, "ishr"),
    LSHR(123, 0x7b, 0, "lshr"),
    IUSHR(124, 0x7c, 0, "iushr"),
    LUSHR(125, 0x7d, 0, "lushr"),
    IAND(126, 0x7e, 0, "iand"),
    LAND(127, 0x7f, 0, "land"),
    IOR(128, 0x80, 0, "ior"),
    LOR(129, 0x81, 0, "lor"),
    IXOR(130, 0x82, 0, "ixor"),
    LXOR(131, 0x83, 0, "lxor"),
    IINC(132, 0x84, 0, "iinc"),
    I2L(133, 0x85, 0, "i2l"),
    I2F(134, 0x86, 0, "i2f"),
    I2D(135, 0x87, 0, "i2d"),
    L2I(136, 0x88, 0, "l2i"),
    L2F(137, 0x89, 0, "l2f"),
    L2D(138, 0x8a, 0, "l2d"),
    F2I(139, 0x8b, 0, "f2i"),
    F2L(140, 0x8c, 0, "f2l"),
    F2D(141, 0x8d, 0, "f2d"),
    D2I(142, 0x8e, 0, "d2i"),
    D2L(143, 0x8f, 0, "d2l"),
    D2F(144, 0x90, 0, "d2f"),
    I2B(145, 0x91, 0, "i2b"),
    I2C(146, 0x92, 0, "i2c"),
    I2S(147, 0x93, 0, "i2s"),
    LCMP(148, 0x94, 0, "lcmp"),
    FCMPL(149, 0x95, 0, "fcmpl"),
    FCMPG(150, 0x96, 0, "fcmpg"),
    DCMPL(151, 0x97, 0, "dcmpl"),
    DCMPG(152, 0x98, 0, "dcmpg"),
    IFEQ(153, 0x99, 2, "ifeq"),
    IFNE(154, 0x9a, 2, "ifne"),
    IFLT(155, 0x9b, 2, "iflt"),
    IFGE(156, 0x9c, 2, "ifge"),
    IFGT(157, 0x9d, 2, "ifgt"),
    IFLE(158, 0x9e, 2, "ifle"),
    IF_ICMPEQ(159, 0x9f, 2, "if_icmpeq"),
    IF_ICMPNE(160, 0xa0, 2, "if_icmpne"),
    IF_ICMPLT(161, 0xa1, 2, "if_icmplt"),
    IF_ICMPGE(162, 0xa2, 2, "if_icmpge"),
    IF_ICMPGT(163, 0xa3, 2, "if_icmpgt"),
    IF_ICMPLE(164, 0xa4, 2, "if_icmple"),
    IF_ACMPEQ(165, 0xa5, 2, "if_acmpeq"),
    IF_ACMPNE(166, 0xa6, 2, "if_acmpne"),
    GOTO(167, 0xa7, 2, "goto"),
    JSR(168, 0xa8, 2, "jsr"),
    RET(169, 0xa9, 0, "ret"),
    TABLESWITCH(170, 0xaa, 2, "tableswitch"),
    LOOKUPSWITCH(171, 0xab, 2, "lookupswitch"),
    IRETURN(172, 0xac, 0, "ireturn"),
    LRETURN(173, 0xad, 0, "lreturn"),
    FRETURN(174, 0xae, 0, "freturn"),
    DRETURN(175, 0xaf, 0, "dreturn"),
    ARETURN(176, 0xb0, 0, "areturn"),
    RETURN(177, 0xb1, 0, "return"),
    GETSTATIC(178, 0xb2, 2, "getstatic"),
    PUTSTATIC(179, 0xb3, 2, "putstatic"),
    GETFIELD(180, 0xb4, 2, "getfield"),
    PUTFIELD(181, 0xb5, 2, "putfield"),
    INVOKEVIRTUAL(182, 0xb6, 2, "invokevirtual"),
    INVOKESPECIAL(183, 0xb7, 2, "invokespecial"),
    INVOKESTATIC(184, 0xb8, 2, "invokestatic"),
    INVOKEINTERFACE(185, 0xb9, 4, "invokeinterface"),
    INVOKEDYNAMIC(186, 0xba, 4, "invokedynamic"),
    NEW(187, 0xbb, 2, "new"),
    NEWARRAY(188, 0xbc, 1, "newarray"),
    ANEWARRAY(189, 0xbd, 2, "anewarray"),
    ARRAYLENGTH(190, 0xbe, 0, "arraylength"),
    ATHROW(191, 0xbf, 0, "athrow"),
    CHECKCAST(192, 0xc0, 0, "checkcast"),
    INSTANCEOF(193, 0xc1, 0, "instanceof"),
    MONITORENTER(194, 0xc2, 0, "monitorenter"),
    MONITOREXIT(195, 0xc3, 0, "monitorexit"),
    WIDE(196, 0xc4, 5, "wide"),
    MULTIANEWARRAY(197, 0xc5, 3, "multianewarray"),
    IFNULL(198, 0xc6, 2, "ifnull"),
    IFNONNULL(199, 0xc7, 2, "ifnonnull"),
    GOTO_W(200, 0xc8, 4, "goto_w"),
    JSR_W(201, 0xc9, 4, "jsr_w"),
    BREAKPOINT(202, 0xca, 0, "breakpoint"),
    IMPDEP1(254, 0xfe, 0, "impdep1"),
    IMPDEP2(255, 0xff, 0, "impdep2");

    OpCode(int id, int hex, int len, String code) {
        this.id = id;
        this.hex = hex;
        this.len = len;
        this.code = code;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getHex() {
        return hex;
    }

    public void setHex(int hex) {
        this.hex = hex;
    }

    public int getLen() {
        return len;
    }

    public void setLen(int len) {
        this.len = len;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    private int id;
    private int hex;
    private int len;
    private String code;



    public static OpCode match(int id) {
        for (OpCode item : OpCode.values()) {
            if (item.hex ==id ) {
                return item;
            }
        }
        return null;
    }

}
