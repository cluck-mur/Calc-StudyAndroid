package jp.camluck.mura.calc;

import android.util.Log;

public class CalculatorCore {
    public float NumBuffer = 0;
    public AppMode Mode;
    public AppMode PreviousMode;

    public enum AppMode {
        None,
        Remembered,
        Add,        // 足し算モード
        Subtract,   // 引き算モード
        Multiply,   // 掛け算モード
        Divide,     // 割り算モード
    }

    /**
     * コンストラクタ
     */
    CalculatorCore() {
        this.NumBuffer = 0;
        this.Mode = AppMode.None;
        this.PreviousMode = AppMode.None;
        {
            StackTraceElement throwableStackTraceElement = new Throwable().getStackTrace()[0];
            Log.d("debug", String.format("%s#%s(%s) ", throwableStackTraceElement.getClassName(), throwableStackTraceElement.getMethodName(), throwableStackTraceElement.getLineNumber())
                    + String.format("Mode=%s, NumBuffer=%f", this.Mode, this.NumBuffer));
        }
    }

    /**
     * 一文字目の数字を入力された時、モードを移行する
     */
    void TypedFirstNum() {
        // 計算モードを設定する
        if (this.Mode == AppMode.Remembered) {
            this.Mode = this.PreviousMode;
            this.PreviousMode = AppMode.None;
            {
                StackTraceElement throwableStackTraceElement = new Throwable().getStackTrace()[0];
                Log.d("debug", String.format("%s#%s(%s) ", throwableStackTraceElement.getClassName(), throwableStackTraceElement.getMethodName(), throwableStackTraceElement.getLineNumber())
                        + String.format("Mode=%s, NumBuffer=%f", this.Mode, this.NumBuffer));
            }
        }
    }

    /**
     * 計算実行
     * @return
     */
    float Calculate(float SecondItem) {
        float retval = 0;

        // モードを見て計算を実行する
        switch (this.Mode) {
            case Add:
                // 足し算を実行する
                retval = CalculateAdd(SecondItem);
                break;
            case Subtract:
                // 引き算を実行する
                retval = CalculateSubtract(SecondItem);
                break;
            case Multiply:
                // 掛け算を実行する
                retval = CalculateMultiply(SecondItem);
                break;
            case Divide:
                // 割り算を実行する
                retval = CalculateDivide(SecondItem);
                break;
            default:
                break;
        }

        return retval;
    }

    /**
     * 足し算を実行する
     * @param SecondItem
     */
    public float CalculateAdd(float SecondItem) {
        // 計算
        this.NumBuffer = this.NumBuffer + SecondItem;
        return this.NumBuffer;
    }

    /**
     * 引き算を実行する
     * @param SecondItem
     */
    public float CalculateSubtract(float SecondItem) {
        // 計算
        this.NumBuffer = this.NumBuffer - SecondItem;
        return this.NumBuffer;
    }

    /**
     * 掛け算を実行する
     * @param SecondItem
     */
    public float CalculateMultiply(float SecondItem) {
        // 計算
        this.NumBuffer = this.NumBuffer * SecondItem;
        return this.NumBuffer;
    }

    /**
     * 割り算を実行する
     * @param SecondItem
     */
    public float CalculateDivide(float SecondItem) {
        // 計算
        this.NumBuffer = this.NumBuffer / SecondItem;
        return this.NumBuffer;
    }
}
