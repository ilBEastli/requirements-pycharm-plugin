package ru.meanmail

import com.intellij.lexer.FlexLexer
import com.intellij.psi.TokenType.BAD_CHARACTER
import com.intellij.psi.tree.IElementType
import ru.meanmail.psi.Types.Companion.AND
import ru.meanmail.psi.Types.Companion.AT
import ru.meanmail.psi.Types.Companion.COLON
import ru.meanmail.psi.Types.Companion.COMMA
import ru.meanmail.psi.Types.Companion.COMMENT
import ru.meanmail.psi.Types.Companion.DIGIT
import ru.meanmail.psi.Types.Companion.DOLLAR_SIGN
import ru.meanmail.psi.Types.Companion.DOT
import ru.meanmail.psi.Types.Companion.DQUOTE
import ru.meanmail.psi.Types.Companion.EDITABLE
import ru.meanmail.psi.Types.Companion.ENV_VAR
import ru.meanmail.psi.Types.Companion.EOL
import ru.meanmail.psi.Types.Companion.IDENTIFIER
import ru.meanmail.psi.Types.Companion.IN
import ru.meanmail.psi.Types.Companion.LBRACE
import ru.meanmail.psi.Types.Companion.LETTER
import ru.meanmail.psi.Types.Companion.LPARENTHESIS
import ru.meanmail.psi.Types.Companion.LSBRACE
import ru.meanmail.psi.Types.Companion.MINUS
import ru.meanmail.psi.Types.Companion.NOT
import ru.meanmail.psi.Types.Companion.OR
import ru.meanmail.psi.Types.Companion.PERCENT_SIGN
import ru.meanmail.psi.Types.Companion.PLUS
import ru.meanmail.psi.Types.Companion.PYTHON_STR_C
import ru.meanmail.psi.Types.Companion.QUESTION_MARK
import ru.meanmail.psi.Types.Companion.RBRACE
import ru.meanmail.psi.Types.Companion.REFER
import ru.meanmail.psi.Types.Companion.RPARENTHESIS
import ru.meanmail.psi.Types.Companion.RSBRACE
import ru.meanmail.psi.Types.Companion.SEMICOLON
import ru.meanmail.psi.Types.Companion.SHARP
import ru.meanmail.psi.Types.Companion.SLASH
import ru.meanmail.psi.Types.Companion.SQUOTE
import ru.meanmail.psi.Types.Companion.SUB_DELIMS
import ru.meanmail.psi.Types.Companion.TILDA
import ru.meanmail.psi.Types.Companion.UNDERSCORE
import ru.meanmail.psi.Types.Companion.VERSION
import ru.meanmail.psi.Types.Companion.VERSION_CMP
import ru.meanmail.psi.Types.Companion.WHITE_SPACE
import java.io.Reader
import java.util.*

/**
 * This class is a scanner generated by
 * [JFlex](http://www.jflex.de/) 1.7.0
 * from the specification file <tt>RequirementsLexer.flex</tt>
 */
class RequirementsLexer
/**
 * Creates a new scanner
 *
 * @param   zzReader  the java.io.Reader to read input from.
 */
(private val zzReader: Reader?) : FlexLexer {

    /** the current state of the DFA  */
    private var zzState: Int = 0

    /** the current lexical state  */
    private var zzLexicalState = YYINITIAL

    /** this buffer contains the current text to be matched and is
     * the source of the yytext() string  */
    private var zzBuffer: CharSequence = ""

    /** the textposition at the last accepting state  */
    private var zzMarkedPos: Int = 0

    /** the current text position in the buffer  */
    private var zzCurrentPos: Int = 0

    /** startRead marks the beginning of the yytext() string in the buffer  */
    private var zzStartRead: Int = 0

    /** endRead marks the last character in the buffer, that has been read
     * from input  */
    private var zzEndRead: Int = 0

    /**
     * zzAtBOL == true <=> the scanner is currently at the beginning of a line
     */
    private var zzAtBOL = true

    /** zzAtEOF == true <=> the scanner is at the EOF  */
    private var zzAtEOF: Boolean = false

    /** denotes if the user-EOF-code has already been executed  */
    private var zzEOFDone: Boolean = false

    override fun getTokenStart() = zzStartRead
    override fun getTokenEnd() = tokenStart + yylength()

    internal var stack: Deque<Int> = ArrayDeque<Int>()

    fun yypush(newState: Int) {
        yybegin(newState)
        stack.push(newState)
    }

    fun yypop(): Int {
        if (stack.size == 0) {
            yyinitial()
            return YYINITIAL
        }

        val state = stack.pop()

        if (stack.peek() == null) {
            yyinitial()
        } else {
            yybegin(stack.peek())
        }

        return state
    }

    fun yyinitial() {
        stack.clear()
        yypush(YYINITIAL)
    }

    override fun reset(buffer: CharSequence, start: Int, end: Int,
                       initialState: Int) {
        zzBuffer = buffer
        zzStartRead = start
        zzMarkedPos = tokenStart
        zzCurrentPos = zzMarkedPos
        zzAtEOF = false
        zzAtBOL = true
        zzEndRead = end
        yybegin(initialState)
    }

    /**
     * Refills the input buffer.
     *
     * @return      `false`, iff there was new input.
     *
     * @exception   java.io.IOException  if any I/O-Error occurs
     */
    private fun zzRefill() = true

    /**
     * Returns the current lexical state.
     */
    override fun yystate(): Int {
        return zzLexicalState
    }


    /**
     * Enters a new lexical state
     *
     * @param newState the new lexical state
     */
    override fun yybegin(newState: Int) {
        zzLexicalState = newState
    }

    /**
     * Returns the text matched by the current regular expression.
     */
    fun yytext(): CharSequence {
        return zzBuffer.subSequence(tokenStart, zzMarkedPos)
    }

    /**
     * Returns the character at position <tt>pos</tt> from the
     * matched text.
     *
     * It is equivalent to yytext().charAt(pos), but faster
     *
     * @param pos the position of the character to fetch.
     * A value from 0 to yylength()-1.
     *
     * @return the character at position pos
     */
    fun yycharat(pos: Int): Char {
        return zzBuffer[tokenStart + pos]
    }

    /**
     * Returns the length of the matched text region.
     */
    private fun yylength(): Int {
        return zzMarkedPos - tokenStart
    }

    /**
     * Reports an error that occurred while scanning.
     *
     * In a wellformed scanner (no or only correct usage of
     * yypushback(int) and a match-all fallback rule) this method
     * will only be called with things that "Can't Possibly Happen".
     * If this method is called, something is seriously wrong
     * (e.g. a JFlex bug producing a faulty scanner etc.).
     *
     * Usual syntax/scanner level error handling should be done
     * in error fallback rules.
     *
     * @param   errorCode  the code of the error message to display
     */
    private fun zzScanError(errorCode: Int) {
        throw Error(
                try {
                    ZZ_ERROR_MSG[errorCode]
                } catch (e: ArrayIndexOutOfBoundsException) {
                    ZZ_ERROR_MSG[ZZ_UNKNOWN_ERROR]
                }
        )
    }

    /**
     * Pushes the specified amount of characters back into the input stream.
     *
     * They will be read again by then next call of the scanning method
     *
     * @param number  the number of characters to be read again.
     * This number must not be greater than yylength()!
     */
    fun yypushback(number: Int) {
        if (number > yylength()) {
            zzScanError(ZZ_PUSHBACK_2BIG)
        }

        zzMarkedPos -= number
    }


    /**
     * Contains user EOF-code, which will be executed exactly once,
     * when the end of file is reached
     */
    private fun zzDoEOF() {
        if (!zzEOFDone) {
            zzEOFDone = true

        }
    }


    /**
     * Resumes scanning until the next regular expression is matched,
     * the end of input is encountered or an I/O-Error occurs.
     *
     * @return      the next token
     * @exception   java.io.IOException  if any I/O-Error occurs
     */
    override fun advance(): IElementType? {
        var zzInput: Int
        var zzAction: Int

        // cached fields:
        var zzCurrentPosL: Int
        var zzMarkedPosL: Int
        var zzEndReadL = zzEndRead
        var zzBufferL = zzBuffer

        val zzTransL = ZZ_TRANS
        val zzRowMapL = ZZ_ROWMAP
        val zzAttrL = ZZ_ATTRIBUTE

        while (true) {
            zzMarkedPosL = zzMarkedPos

            zzAction = -1

            zzStartRead = zzMarkedPosL
            zzCurrentPos = tokenStart
            zzCurrentPosL = zzCurrentPos

            zzState = ZZ_LEXSTATE[zzLexicalState]

            // set up zzAction for empty match case:
            var zzAttributes = zzAttrL[zzState]
            if (zzAttributes and 1 == 1) {
                zzAction = zzState
            }

            while (true) {
                if (zzCurrentPosL < zzEndReadL) {
                    zzInput = Character.codePointAt(zzBufferL, zzCurrentPosL/*, zzEndReadL*/)
                    zzCurrentPosL += Character.charCount(zzInput)
                } else if (zzAtEOF) {
                    zzInput = YYEOF
                    break
                } else {
                    // store back cached positions
                    zzCurrentPos = zzCurrentPosL
                    zzMarkedPos = zzMarkedPosL
                    val eof = zzRefill()
                    // get translated positions and possibly new buffer
                    zzCurrentPosL = zzCurrentPos
                    zzMarkedPosL = zzMarkedPos
                    zzBufferL = zzBuffer
                    zzEndReadL = zzEndRead
                    if (eof) {
                        zzInput = YYEOF
                        break
                    } else {
                        zzInput = Character.codePointAt(zzBufferL, zzCurrentPosL/*, zzEndReadL*/)
                        zzCurrentPosL += Character.charCount(zzInput)
                    }
                }
                val zzNext = zzTransL[zzRowMapL[zzState] + ZZ_CMAP(zzInput)]
                if (zzNext == -1) break
                zzState = zzNext

                zzAttributes = zzAttrL[zzState]
                if (zzAttributes and 1 == 1) {
                    zzAction = zzState
                    zzMarkedPosL = zzCurrentPosL
                    if (zzAttributes and 8 == 8) break
                }
            }

            // store back cached position
            zzMarkedPos = zzMarkedPosL

            if (zzInput == YYEOF && tokenStart == zzCurrentPos) {
                zzAtEOF = true
                zzDoEOF()
                return null
            } else {
                when (if (zzAction < 0) zzAction else ZZ_ACTION[zzAction]) {
                    1 -> {
                        return WHITE_SPACE
                    }
                    // fall through
                    49 -> {
                    }
                    2 -> {
                        yyinitial()
                        return BAD_CHARACTER
                    }
                    // fall through
                    50 -> {
                    }
                    3 -> {
                        return COMMENT
                    }
                    // fall through
                    51 -> {
                    }
                    4 -> run {
                        yypush(REQ)
                        yypushback(yylength())
                    }
                    // fall through
                    52 -> {
                    }
                    5 -> {
                        yyinitial()
                        return EOL
                    }
                    // fall through
                    53 -> {
                    }
                    6 -> {
                        yypop()
                        return VERSION
                    }
                    // fall through
                    54 -> {
                    }
                    7 -> {
                        yypop()
                        return COMMENT
                    }
                    // fall through
                    55 -> {
                    }
                    8 -> {
                        return PYTHON_STR_C
                    }
                    // fall through
                    56 -> {
                    }
                    9 -> {
                        yypop()
                        return DQUOTE
                    }
                    // fall through
                    57 -> {
                    }
                    10 -> {
                        yypop()
                        return SQUOTE
                    }
                    // fall through
                    58 -> {
                    }
                    11 -> {
                        yyinitial()
                        return COMMENT
                    }
                    // fall through
                    59 -> {
                    }
                    12 -> {
                        return VERSION_CMP
                    }
                    // fall through
                    60 -> {
                    }
                    13 -> {
                        return LPARENTHESIS
                    }
                    // fall through
                    61 -> {
                    }
                    14 -> {
                        return RPARENTHESIS
                    }
                    // fall through
                    62 -> {
                    }
                    15 -> {
                        yypush(DQUOTE_STR)
                        return DQUOTE
                    }
                    // fall through
                    63 -> {
                    }
                    16 -> {
                        yypush(SQUOTE_STR)
                        return SQUOTE
                    }
                    // fall through
                    64 -> {
                    }
                    17 -> {
                        return PLUS
                    }
                    // fall through
                    65 -> {
                    }
                    18 -> {
                        return MINUS
                    }
                    // fall through
                    66 -> {
                    }
                    19 -> {
                        return SUB_DELIMS
                    }
                    // fall through
                    67 -> {
                    }
                    20 -> {
                        return COLON
                    }
                    // fall through
                    68 -> {
                    }
                    21 -> {
                        return QUESTION_MARK
                    }
                    // fall through
                    69 -> {
                    }
                    22 -> {
                        return LSBRACE
                    }
                    // fall through
                    70 -> {
                    }
                    23 -> {
                        return RSBRACE
                    }
                    // fall through
                    71 -> {
                    }
                    24 -> {
                        return AT
                    }
                    // fall through
                    72 -> {
                    }
                    25 -> {
                        return DOLLAR_SIGN
                    }
                    // fall through
                    73 -> {
                    }
                    26 -> {
                        return SHARP
                    }
                    // fall through
                    74 -> {
                    }
                    27 -> {
                        return PERCENT_SIGN
                    }
                    // fall through
                    75 -> {
                    }
                    28 -> {
                        return SLASH
                    }
                    // fall through
                    76 -> {
                    }
                    29 -> {
                        return DOT
                    }
                    // fall through
                    77 -> {
                    }
                    30 -> {
                        return UNDERSCORE
                    }
                    // fall through
                    78 -> {
                    }
                    31 -> {
                        return LBRACE
                    }
                    // fall through
                    79 -> {
                    }
                    32 -> {
                        return RBRACE
                    }
                    // fall through
                    80 -> {
                    }
                    33 -> {
                        return TILDA
                    }
                    // fall through
                    81 -> {
                    }
                    34 -> {
                        return LETTER
                    }
                    // fall through
                    82 -> {
                    }
                    35 -> {
                        return DIGIT
                    }
                    // fall through
                    83 -> {
                    }
                    36 -> {
                        yypush(QUOTED_MARK)
                        return SEMICOLON
                    }
                    // fall through
                    84 -> {
                    }
                    37 -> {
                        return COMMA
                    }
                    // fall through
                    85 -> {
                    }
                    38 -> {
                        yypush(URI)
                        return AT
                    }
                    // fall through
                    86 -> {
                    }
                    39 -> run {
                        yypush(URI)
                        yypushback(yylength())
                    }
                    // fall through
                    87 -> {
                    }
                    40 -> {
                        return IDENTIFIER
                    }
                    // fall through
                    88 -> {
                    }
                    41 -> {
                        yypush(WAITING_VERSION)
                        return VERSION_CMP
                    }
                    // fall through
                    89 -> {
                    }
                    42 -> {
                        yypush(URI)
                        return EDITABLE
                    }
                    // fall through
                    90 -> {
                    }
                    43 -> {
                        yypush(URI)
                        return REFER
                    }
                    // fall through
                    91 -> {
                    }
                    44 -> {
                        return OR
                    }
                    // fall through
                    92 -> {
                    }
                    45 -> {
                        return IN
                    }
                    // fall through
                    93 -> {
                    }
                    46 -> {
                        return NOT
                    }
                    // fall through
                    94 -> {
                    }
                    47 -> {
                        return AND
                    }
                    // fall through
                    95 -> {
                    }
                    48 -> {
                        return ENV_VAR
                    }
                    // fall through
                    96 -> {
                    }
                    else -> zzScanError(ZZ_NO_MATCH)
                }
            }
        }
    }

    companion object {

        /** This character denotes the end of file  */
        val YYEOF = -1

        /** initial size of the lookahead buffer  */
        private val ZZ_BUFFERSIZE = 16384

        /** lexical states  */
        val YYINITIAL = 0
        val WAITING_VERSION = 2
        val DQUOTE_STR = 4
        val SQUOTE_STR = 6
        val QUOTED_MARK = 8
        val URI = 10
        val REQ = 12

        /**
         * ZZ_LEXSTATE[l] is the state in the DFA for the lexical state l
         * ZZ_LEXSTATE[l+1] is the state in the DFA for the lexical state l
         * at the beginning of a line
         * l is of the form l = 2*k, k a non negative integer
         */
        private val ZZ_LEXSTATE = intArrayOf(0, 0, 1, 1, 2, 2, 3, 3, 4, 4, 5, 5, 6, 6)

        /**
         * Translates characters to character classes
         * Chosen bits are [7, 7, 7]
         * Total runtime size is 1928 bytes
         */
        fun ZZ_CMAP(ch: Int): Int {
            return ZZ_CMAP_A[ZZ_CMAP_Y[ZZ_CMAP_Z[ch shr 14].toInt() or (ch shr 7 and 0x7f)].toInt() shl 7 or (ch and 0x7f)].toInt()
        }

        /* The ZZ_CMAP_Z table has 68 entries */
        internal val ZZ_CMAP_Z = zzUnpackCMap(
                "\u0001\u0000\u0043\u0080")

        /* The ZZ_CMAP_Y table has 256 entries */
        internal val ZZ_CMAP_Y = zzUnpackCMap(
                "\u0001\u0000\u0001\u0001\u002b\u0002\u0001\u0003\u0012\u0002\u0001\u0004\u001f\u0002\u0001\u0003\u009f\u0002")

        /* The ZZ_CMAP_A table has 640 entries */
        internal val ZZ_CMAP_A = zzUnpackCMap(
                "\u0009\u001b\u0001\u0000\u0001\u0017\u0002\u0018\u0001\u0017\u0012\u001b\u0001\u0000\u0001\u000a\u0001\u0032\u0001\u000d\u0001\u000c\u0001\u000e\u0001\u0015\u0001\u0033\u0001\u001d" +
                        "\u0001\u001e\u0001\u0003\u0001\u0001\u0001\u0006\u0001\u0002\u0001\u0010\u0001\u000f\u000a\u001a\u0001\u0004\u0001\u0005\u0001\u001c\u0001\u0014\u0001\u001c\u0001\u0007\u0001\u000b\u001a\u0019" +
                        "\u0001\u0008\u0001\u001b\u0001\u0009\u0001\u0031\u0001\u0011\u0001\u0031\u0001\u002d\u0001\u0019\u0001\u002f\u0001\u0034\u0001\u0026\u0001\u002a\u0001\u0019\u0001\u0022\u0001\u0029" +
                        "\u0002\u0019\u0001\u002c\u0001\u002e\u0001\u0024\u0001\u0023\u0001\u001f\u0001\u0019\u0001\u0027\u0001\u0028\u0001\u0021\u0001\u002b\u0001\u0025\u0001\u0019\u0001\u0030\u0001\u0020" +
                        "\u0001\u0019\u0001\u0012\u0001\u0031\u0001\u0013\u0001\u0016\u0006\u001b\u0001\u0018\u001a\u001b\u0001\u0000\u00df\u001b\u0001\u0000\u007f\u001b\u000b\u0000\u001d\u001b" +
                        "\u0002\u0018\u0005\u001b\u0001\u0000\u002f\u001b\u0001\u0000\u0020\u001b")

        /**
         * Translates DFA states to action switch labels.
         */
        private val ZZ_ACTION = zzUnpackAction()

        private val ZZ_ACTION_PACKED_0 = "\u0007\u0000\u0001\u0001\u0002\u0002\u0001\u0003\u0001\u0004\u0001\u0005\u0001\u0001\u0001\u0004" +
                "\u0001\u0006\u0001\u0007\u0003\u0008\u0001\u0009\u0001\u000a\u0001\u0002\u0001\u000b\u0001\u0002" +
                "\u0001\u000c\u0001\u000d\u0001\u000e\u0007\u0002\u0001\u000f\u0001\u0010\u0001\u0001\u0001\u0011" +
                "\u0001\u0012\u0001\u0013\u0001\u0014\u0001\u0015\u0001\u0016\u0001\u0017\u0001\u0018\u0001\u0019" +
                "\u0001\u001a\u0001\u001b\u0001\u001c\u0001\u001d\u0001\u001e\u0001\u001f\u0001\u0020\u0001\u0021" +
                "\u0001\u0001\u0001\u0022\u0001\u0023\u0001\u0001\u0001\u0024\u0001\u0025\u0001\u0002\u0001\u0026" +
                "\u0001\u0027\u0001\u0002\u0001\u0001\u0001\u0028\u0001\u0029\u0001\u002a\u0001\u002b\u0001\u0000" +
                "\u0001\u000c\u0002\u0000\u0001\u002c\u0004\u0000\u0001\u002d\u0002\u0000\u0001\u0029\u0004\u0000" +
                "\u0001\u002e\u0003\u0000\u0001\u002f\u0009\u0000\u0001\u0030\u0043\u0000"

        private fun zzUnpackAction(): IntArray {
            val result = IntArray(169)
            zzUnpackAction(ZZ_ACTION_PACKED_0, 0, result)
            return result
        }

        private fun zzUnpackAction(packed: String, offset: Int, result: IntArray): Int {
            var i = 0       /* index in packed string  */
            var j = offset  /* index in unpacked array */
            val l = packed.length
            while (i < l) {
                var count = packed[i++].toInt()
                val value = packed[i++].toInt()
                do result[j++] = value while (--count > 0)
            }
            return j
        }


        /**
         * Translates a state to a row index in the transition table
         */
        private val ZZ_ROWMAP = zzUnpackRowMap()

        private val ZZ_ROWMAP_PACKED_0 = "\u0000\u0000\u0000\u0035\u0000\u006a\u0000\u009f\u0000\u00d4\u0000\u0109\u0000\u013e\u0000\u0173" +
                "\u0000\u01a8\u0000\u01dd\u0000\u0212\u0000\u01a8\u0000\u0247\u0000\u027c\u0000\u02b1\u0000\u02e6" +
                "\u0000\u031b\u0000\u0350\u0000\u01a8\u0000\u0385\u0000\u01a8\u0000\u01a8\u0000\u03ba\u0000\u03ef" +
                "\u0000\u0424\u0000\u03ba\u0000\u01a8\u0000\u01a8\u0000\u0459\u0000\u048e\u0000\u04c3\u0000\u04f8" +
                "\u0000\u052d\u0000\u0562\u0000\u0597\u0000\u01a8\u0000\u01a8\u0000\u05cc\u0000\u01a8\u0000\u01a8" +
                "\u0000\u01a8\u0000\u01a8\u0000\u01a8\u0000\u01a8\u0000\u01a8\u0000\u01a8\u0000\u01a8\u0000\u01a8" +
                "\u0000\u01a8\u0000\u01a8\u0000\u01a8\u0000\u01a8\u0000\u01a8\u0000\u01a8\u0000\u01a8\u0000\u0601" +
                "\u0000\u01a8\u0000\u01a8\u0000\u0636\u0000\u01a8\u0000\u01a8\u0000\u066b\u0000\u01a8\u0000\u01a8" +
                "\u0000\u06a0\u0000\u06d5\u0000\u070a\u0000\u066b\u0000\u01a8\u0000\u01a8\u0000\u02b1\u0000\u01a8" +
                "\u0000\u073f\u0000\u0774\u0000\u01a8\u0000\u07a9\u0000\u07de\u0000\u0813\u0000\u0848\u0000\u01a8" +
                "\u0000\u087d\u0000\u08b2\u0000\u01a8\u0000\u08e7\u0000\u091c\u0000\u0951\u0000\u0986\u0000\u01a8" +
                "\u0000\u09bb\u0000\u09f0\u0000\u0a25\u0000\u01a8\u0000\u0a5a\u0000\u0a8f\u0000\u0ac4\u0000\u0af9" +
                "\u0000\u0b2e\u0000\u0b63\u0000\u0b98\u0000\u0bcd\u0000\u0c02\u0000\u01a8\u0000\u0c37\u0000\u0c6c" +
                "\u0000\u0ca1\u0000\u0cd6\u0000\u0d0b\u0000\u0d40\u0000\u0d75\u0000\u0daa\u0000\u0ddf\u0000\u0e14" +
                "\u0000\u0e49\u0000\u0e7e\u0000\u0eb3\u0000\u0ee8\u0000\u0f1d\u0000\u0f52\u0000\u0f87\u0000\u0fbc" +
                "\u0000\u0ff1\u0000\u1026\u0000\u105b\u0000\u1090\u0000\u10c5\u0000\u10fa\u0000\u112f\u0000\u1164" +
                "\u0000\u1199\u0000\u11ce\u0000\u1203\u0000\u1238\u0000\u126d\u0000\u12a2\u0000\u12d7\u0000\u130c" +
                "\u0000\u1341\u0000\u1376\u0000\u13ab\u0000\u13e0\u0000\u1415\u0000\u144a\u0000\u147f\u0000\u14b4" +
                "\u0000\u14e9\u0000\u151e\u0000\u1553\u0000\u1588\u0000\u15bd\u0000\u15f2\u0000\u1627\u0000\u165c" +
                "\u0000\u1691\u0000\u16c6\u0000\u16fb\u0000\u1730\u0000\u1765\u0000\u179a\u0000\u17cf\u0000\u1804" +
                "\u0000\u1839\u0000\u186e\u0000\u18a3\u0000\u18d8\u0000\u190d\u0000\u1942\u0000\u1977\u0000\u19ac" +
                "\u0000\u19e1"

        private fun zzUnpackRowMap(): IntArray {
            val result = IntArray(169)
            zzUnpackRowMap(ZZ_ROWMAP_PACKED_0, 0, result)
            return result
        }

        private fun zzUnpackRowMap(packed: String, offset: Int, result: IntArray): Int {
            var i = 0  /* index in packed string  */
            var j = offset  /* index in unpacked array */
            val l = packed.length
            while (i < l) {
                val high = packed[i++].toInt() shl 16
                result[j++] = high or packed[i++].toInt()
            }
            return j
        }

        /**
         * The transition table of the DFA
         */
        private val ZZ_TRANS = zzUnpackTrans()

        private val ZZ_TRANS_PACKED_0 = "\u0001\u0008\u0001\u0009\u0001\u000a\u000a\u0009\u0001\u000b\u0002\u0009\u0001\u000c\u0006\u0009" +
                "\u0001\u000d\u0001\u000e\u0002\u000f\u0004\u0009\u0012\u000f\u0003\u0009\u0001\u000f\u0001\u0008" +
                "\u0003\u0010\u0006\u0009\u0001\u0010\u0002\u0009\u0001\u0011\u0002\u0009\u0002\u0010\u0005\u0009" +
                "\u0001\u000d\u0001\u000e\u0002\u0010\u0004\u0009\u0012\u0010\u0003\u0009\u0001\u0010\u0001\u0012" +
                "\u0016\u0013\u0001\u000d\u0001\u0014\u0002\u0013\u0001\u0009\u0016\u0013\u0001\u0015\u0001\u0009" +
                "\u0001\u0013\u0001\u0012\u0016\u0013\u0001\u000d\u0001\u0014\u0002\u0013\u0001\u0009\u0016\u0013" +
                "\u0001\u0009\u0001\u0016\u0001\u0013\u0001\u0008\u0009\u0009\u0001\u0017\u0002\u0009\u0001\u0018" +
                "\u0006\u0009\u0001\u0019\u0001\u0009\u0001\u0017\u0001\u000d\u0001\u000e\u0003\u0009\u0001\u001a" +
                "\u0001\u001b\u0001\u001c\u0001\u001d\u0003\u0009\u0001\u001e\u0001\u001f\u0001\u0009\u0001\u0020" +
                "\u0001\u0009\u0001\u0021\u0001\u0022\u0003\u0009\u0001\u0023\u0004\u0009\u0001\u0024\u0001\u0025" +
                "\u0001\u0009\u0001\u0026\u0001\u0027\u0001\u0028\u0001\u0029\u0001\u002a\u0002\u0029\u0001\u002b" +
                "\u0001\u002c\u0001\u002d\u0001\u0029\u0001\u002e\u0001\u002f\u0001\u0030\u0001\u0031\u0001\u0032" +
                "\u0001\u0033\u0001\u0034\u0001\u0035\u0001\u0036\u0002\u0029\u0001\u0037\u0001\u000d\u0001\u0038" +
                "\u0001\u0039\u0001\u003a\u0002\u0009\u0002\u0029\u0012\u0039\u0002\u0009\u0001\u0029\u0001\u0039" +
                "\u0001\u003b\u0004\u0009\u0001\u003c\u0001\u003d\u0001\u0009\u0001\u002c\u0001\u002d\u0001\u003e" +
                "\u0001\u003f\u0004\u0009\u0001\u0040\u0003\u0009\u0001\u0041\u0001\u0009\u0001\u003e\u0001\u000d" +
                "\u0001\u0042\u0002\u0043\u0001\u0009\u0001\u0044\u0001\u001b\u0001\u001c\u0012\u0043\u0003\u0009" +
                "\u0001\u0043\u0001\u0008\u0017\u0000\u0001\u0008\u0077\u0000\u0001\u0045\u0001\u0046\u000d\u0000" +
                "\u0017\u000b\u0002\u0000\u001c\u000b\u0017\u0000\u0002\u000d\u001c\u0000\u0001\u0008\u0016\u0000" +
                "\u0001\u000d\u0001\u000e\u001e\u0000\u0001\u0047\u000d\u0000\u0002\u0047\u0007\u0000\u0002\u000f" +
                "\u0004\u0000\u0012\u000f\u0003\u0000\u0001\u000f\u0001\u0000\u0003\u0010\u0006\u0000\u0001\u0010" +
                "\u0005\u0000\u0002\u0010\u0007\u0000\u0002\u0010\u0004\u0000\u0012\u0010\u0003\u0000\u0001\u0010" +
                "\u0017\u0011\u0002\u0000\u001c\u0011\u0001\u0012\u0017\u0000\u0001\u0012\u001c\u0000\u0001\u0012" +
                "\u0016\u0000\u0001\u000d\u0001\u0014\u0030\u0000\u0001\u0048\u0020\u0000\u0017\u0018\u0002\u0000" +
                "\u001c\u0018\u0014\u0000\u0001\u001a\u0040\u0000\u0001\u0049\u000b\u0000\u0001\u004a\u002f\u0000" +
                "\u0001\u004b\u0001\u004c\u002f\u0000\u0001\u004d\u0041\u0000\u0001\u004e\u0024\u0000\u0001\u004f" +
                "\u0038\u0000\u0001\u0050\u0009\u0000\u0001\u0051\u002a\u0000\u0001\u0052\u0010\u0000\u0001\u0026" +
                "\u0004\u0000\u0001\u003c\u0007\u0000\u0001\u0018\u000a\u0000\u0001\u0026\u001c\u0000\u0001\u0026" +
                "\u0004\u0000\u0001\u003c\u0007\u0000\u0001\u0018\u0009\u0000\u0001\u000d\u0001\u0038\u001c\u0000" +
                "\u0001\u003b\u000c\u0000\u0001\u0018\u000a\u0000\u0001\u003b\u0030\u0000\u0001\u0053\u0034\u0000" +
                "\u0001\u0044\u0020\u0000\u0001\u003b\u000c\u0000\u0001\u0018\u0009\u0000\u0001\u000d\u0001\u0042" +
                "\u001d\u0000\u0001\u0040\u0001\u0054\u0001\u0000\u0001\u0040\u000b\u0000\u0002\u0054\u0007\u0000" +
                "\u0002\u0043\u0004\u0000\u0012\u0043\u0003\u0000\u0001\u0043\u0021\u0000\u0001\u0055\u0040\u0000" +
                "\u0001\u0056\u0018\u0000\u0001\u0057\u0044\u0000\u0001\u0058\u0034\u0000\u0001\u0059\u003b\u0000" +
                "\u0001\u005a\u002b\u0000\u0001\u005b\u0049\u0000\u0001\u005c\u0002\u0000\u0001\u0054\u000d\u0000" +
                "\u0002\u0054\u0007\u0000\u0002\u0043\u0004\u0000\u0012\u0043\u0003\u0000\u0001\u0043\u0022\u0000" +
                "\u0001\u005d\u0033\u0000\u0001\u005e\u0037\u0000\u0001\u005f\u0037\u0000\u0001\u0060\u001e\u0000" +
                "\u0001\u0061\u004f\u0000\u0001\u0062\u002b\u0000\u0001\u0063\u003b\u0000\u0001\u0064\u0037\u0000" +
                "\u0001\u0065\u0034\u0000\u0001\u0066\u0026\u0000\u0001\u0067\u003b\u0000\u0001\u0068\u0032\u0000" +
                "\u0001\u0069\u0033\u0000\u0001\u006a\u003f\u0000\u0001\u006b\u0032\u0000\u0001\u006c\u0036\u0000" +
                "\u0001\u006d\u0017\u0000\u0001\u006e\u004a\u0000\u0001\u006f\u0033\u0000\u0001\u0066\u003b\u0000" +
                "\u0001\u0070\u002d\u0000\u0001\u0071\u0033\u0000\u0001\u0072\u0004\u0000\u0001\u0073\u0038\u0000" +
                "\u0001\u0074\u0027\u0000\u0001\u0075\u0037\u0000\u0001\u0076\u0036\u0000\u0001\u0077\u0039\u0000" +
                "\u0001\u0078\u001a\u0000\u0001\u0079\u004d\u0000\u0001\u007a\u002b\u0000\u0001\u007b\u003a\u0000" +
                "\u0001\u007c\u0039\u0000\u0001\u007d\u0027\u0000\u0001\u007e\u0005\u0000\u0001\u0072\u0001\u0000" +
                "\u0001\u007f\u0001\u0080\u0005\u0000\u0001\u0081\u0029\u0000\u0001\u0082\u003e\u0000\u0001\u0083" +
                "\u002f\u0000\u0001\u0084\u0038\u0000\u0001\u0085\u0028\u0000\u0001\u0086\u003a\u0000\u0001\u0087" +
                "\u002e\u0000\u0001\u0088\u0041\u0000\u0001\u0089\u002e\u0000\u0001\u008a\u002e\u0000\u0001\u008b" +
                "\u003c\u0000\u0001\u008c\u001c\u0000\u0001\u008d\u0044\u0000\u0001\u008e\u003f\u0000\u0001\u008f" +
                "\u0030\u0000\u0001\u0090\u003b\u0000\u0001\u0091\u0033\u0000\u0001\u0066\u002f\u0000\u0001\u0092" +
                "\u002e\u0000\u0001\u0093\u0036\u0000\u0001\u0072\u0031\u0000\u0001\u0094\u0038\u0000\u0001\u0095" +
                "\u002f\u0000\u0001\u0096\u0035\u0000\u0001\u0097\u0035\u0000\u0001\u0098\u0035\u0000\u0001\u0066" +
                "\u0033\u0000\u0001\u0099\u003e\u0000\u0001\u009a\u002d\u0000\u0001\u008a\u0037\u0000\u0001\u009b" +
                "\u002f\u0000\u0001\u009c\u0034\u0000\u0001\u009d\u0038\u0000\u0001\u006b\u0030\u0000\u0001\u006b" +
                "\u0021\u0000\u0001\u009e\u0034\u0000\u0001\u009f\u0047\u0000\u0001\u005f\u0001\u0072\u0038\u0000" +
                "\u0001\u00a0\u0039\u0000\u0001\u00a1\u0025\u0000\u0001\u00a2\u0041\u0000\u0001\u00a3\u002e\u0000" +
                "\u0001\u00a4\u003c\u0000\u0001\u00a5\u002c\u0000\u0001\u00a6\u0032\u0000\u0001\u00a7\u0031\u0000" +
                "\u0001\u00a8\u0040\u0000\u0001\u00a9\u0028\u0000\u0001\u0084\u0013\u0000"

        private fun zzUnpackTrans(): IntArray {
            val result = IntArray(6678)
            zzUnpackTrans(ZZ_TRANS_PACKED_0, 0, result)
            return result
        }

        private fun zzUnpackTrans(packed: String, offset: Int, result: IntArray): Int {
            var i = 0       /* index in packed string  */
            var j = offset  /* index in unpacked array */
            val l = packed.length
            while (i < l) {
                var count = packed[i++].toInt()
                var value = packed[i++].toInt()
                value--
                do result[j++] = value while (--count > 0)
            }
            return j
        }


        /* error codes */
        private const val ZZ_UNKNOWN_ERROR = 0
        private const val ZZ_NO_MATCH = 1
        private const val ZZ_PUSHBACK_2BIG = 2

        /* error messages for the codes above */
        private val ZZ_ERROR_MSG = arrayOf(
                "Unknown internal scanner error",
                "Error: could not match input",
                "Error: pushback value was too large"
        )

        /**
         * ZZ_ATTRIBUTE[aState] contains the attributes of state `aState`
         */
        private val ZZ_ATTRIBUTE = zzUnpackAttribute()

        private val ZZ_ATTRIBUTE_PACKED_0 = "\u0007\u0000\u0001\u0001\u0001\u0009\u0002\u0001\u0001\u0009\u0006\u0001\u0001\u0009\u0001\u0001" +
                "\u0002\u0009\u0004\u0001\u0002\u0009\u0007\u0001\u0002\u0009\u0001\u0001\u0011\u0009\u0001\u0001" +
                "\u0002\u0009\u0001\u0001\u0002\u0009\u0001\u0001\u0002\u0009\u0004\u0001\u0002\u0009\u0001\u0000" +
                "\u0001\u0009\u0002\u0000\u0001\u0009\u0004\u0000\u0001\u0009\u0002\u0000\u0001\u0009\u0004\u0000" +
                "\u0001\u0009\u0003\u0000\u0001\u0009\u0009\u0000\u0001\u0009\u0043\u0000"

        private fun zzUnpackAttribute(): IntArray {
            val result = IntArray(169)
            var offset = 0
            offset = zzUnpackAttribute(ZZ_ATTRIBUTE_PACKED_0, offset, result)
            return result
        }

        private fun zzUnpackAttribute(packed: String, offset: Int, result: IntArray): Int {
            var i = 0       /* index in packed string  */
            var j = offset  /* index in unpacked array */
            val l = packed.length
            while (i < l) {
                var count = packed[i++].toInt()
                val value = packed[i++].toInt()
                do result[j++] = value while (--count > 0)
            }
            return j
        }


        /**
         * Unpacks the compressed character translation table.
         *
         * @param packed   the packed character translation table
         * @return         the unpacked character translation table
         */
        private fun zzUnpackCMap(packed: String): CharArray {
            var size = 0
            var k = 0
            val length = packed.length
            while (k < length) {
                size += packed[k].toInt()
                k += 2
            }
            val map = CharArray(size)
            var i = 0  /* index in packed string  */
            var j = 0  /* index in unpacked array */
            while (i < packed.length) {
                var count = packed[i++].toInt()
                val value = packed[i++]
                do map[j++] = value while (--count > 0)
            }
            return map
        }
    }
}
