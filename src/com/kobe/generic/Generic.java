package com.kobe.generic;

/* 娉涘瀷浣跨敤鍦烘櫙
1. 鐢ㄤ簬闆嗗悎
缂栬瘧鏈熼棿绫诲瀷妫�鏌ワ紝 琛ㄧず鏀归泦鍚堝彲浠ュ瓨鏀炬寚瀹氱被鍨嬬殑鍏冪礌
2. 鐢ㄤ簬绫�
鏅�氱被鐨勪唬鐮佸伐鍘傦紝鑺傜渷瀹氫箟鐩镐技绫荤殑閲嶅浠ｇ爜锛�
3. 鐢ㄤ簬鏂规硶
鍙傛暟锛岃繑鍥炲�煎彲浠ラ�傞厤鎸囧畾绫诲瀷
*/

/* 娉涘瀷鐨勫ソ澶�
* 1. Generic VS Object
* 鍙鎬уソ锛屽仴澹�уソ
* 2. 閬垮厤浠ｇ爜閲嶅
* 3. 闄愬埗绫诲瀷 - 鍙帴鍙楁兂鎺ュ彈鐨勭被鍨�
* <T extends XX, YY> 鍏朵腑XX, YY鍙互鏄竴涓被锛屼篃鍙互鏄竴涓帴鍙�
* 鎴栬��<? extends XX, YY, ZZ>,琛ㄧず浠绘剰缁ф壙涓嶺X鐨勫瓙绫伙紝鎴栬�呮槸瀹炵幇浜哫X鎺ュ彛鐨勭被

* 4. Generic VS 绫荤殑缁ф壙
* 鍦↗AVA寮曞叆娉涘瀷涔嬪墠锛宩ava绋嬪簭鐢ㄧ户鎵挎潵鍋氬埌娉涘瀷锛岀紪璇戞湡闂村鎬�
* */

/* 娉涘瀷鐨勬摝闄ゅ甫鏉ョ殑灞�闄愭��
* 锛侊紒锛侊紒锛侊紒
* 1锛塉VM閲屾病鏈夋硾鍨嬶紝娉涘瀷鍦ㄨ繍琛屾湡闂翠細琚摝闄�
* 2锛夋硾鍨嬫摝闄よ鍒欏氨鏄�: 鏈夐檺鍒剁被鍨嬬殑锛屽氨淇濈暀闄愬埗绫诲瀷锛屾病鏈夐檺鍒剁被鍨嬬殑灏辩敤Object
* 3锛塉VM鑷姩鍔犱笂寮哄埗绫诲瀷杞崲
* 锛侊紒锛侊紒锛�
* */

import com.kobe.equalsAndHashcode.Person;

import java.util.ArrayList;
import java.util.List;

public class Generic<T> {
    public <T extends Comparable> T findSmall(List<T> collection) {
        if (collection == null || collection.isEmpty()) {
            return null;
        }
        T smallest = collection.get(0);
        for (T t : collection) {
            if (t.compareTo(smallest) < 0) {
                smallest = t;
            }
        }
        return smallest;
    }
}
