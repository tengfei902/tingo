package tingo.core.lang;

/**
 * Created by user on 17/7/31.
 */
public final class SelfDefineString {
    private final char value[];

    public SelfDefineString() {
        this.value = "".toCharArray();
    }

    public SelfDefineString(SelfDefineString original) {
        this.value = original.value;
    }
}
