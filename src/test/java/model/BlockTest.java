package model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator.ReplaceUnderscores;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayNameGeneration(ReplaceUnderscores.class)
class BlockTest {

    @ParameterizedTest
    @ValueSource(booleans = {true, false})
    void BLOCK은_생성자의_파라미터로_BOOLEAN값을_받아_BLOCK을_생성한다(boolean pass) {
        //Block을 생성할 때 파라미터로 pass 필드 값이 들어가있지 않으면 예외 발생
        assertThatCode(() -> new Block(pass)).doesNotThrowAnyException();
    }

    @ParameterizedTest
    @CsvSource(value = {"true:true:true", "true:false:false", "false:true:false", "false:false:false"}, delimiter = ':')
    void isLeftBlockHavePass_메소드는_왼쪽의_BLOCK의_PASS가_TRUE이고_자기자신의_PASS도_TRUE이면_TRUE를_반환한다(boolean leftBlockPass,
        boolean nowBlockPass, boolean expected) {
        Block leftBlock = new Block(leftBlockPass);
        Block nowBlock = new Block(nowBlockPass);
        assertThat(nowBlock.isLeftBlockHavePass(leftBlock)).isEqualTo(expected);
    }
}