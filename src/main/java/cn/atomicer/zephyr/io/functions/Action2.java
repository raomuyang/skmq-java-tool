package cn.atomicer.zephyr.io.functions;

/**
 * @author Rao-Mengnan
 *         on 2018/1/30.
 */
public interface Action2<T1, T2> {
    void doAction(T1 t1, T2 t2) throws Exception;
}
