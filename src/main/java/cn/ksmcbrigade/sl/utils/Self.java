package cn.ksmcbrigade.sl.utils;

public interface Self<T> {
    default T getSelf(){
        return ((T)((Object)this));
    }
}
