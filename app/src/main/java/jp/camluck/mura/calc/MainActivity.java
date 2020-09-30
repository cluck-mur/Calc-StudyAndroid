package jp.camluck.mura.calc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // 計算機本体
    CalculatorCore CalculatorCore = null;

    // 画面制御用フィールド
    public boolean IsWaitFirstNum = false;
    public String InitialNum = "0";


    /*
    public float NumBuffer = 0;
    public boolean IsWaitFirstNum = false;
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
    */

    /**
     * 画面初期化
     *
     * @param savedInstanceState
     **/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // クラスメンバ変数初期化
        CalculatorCore = new CalculatorCore();

        /*
        this.NumBuffer = 0;
        this.Mode = AppMode.None;
        this.PreviousMode = AppMode.None;
        {
            StackTraceElement throwableStackTraceElement = new Throwable().getStackTrace()[0];
            Log.d("debug", String.format("%s#%s(%s) ", throwableStackTraceElement.getClassName(), throwableStackTraceElement.getMethodName(), throwableStackTraceElement.getLineNumber())
                    + String.format("Mode=%s, NumBuffer=%f", this.Mode, this.NumBuffer));
        }
         */

        // メインビューにコンテンツを設定する
        setContentView(R.layout.activity_main);

        // テキストビューを取得（出力先）
        TextView text_view = this.findViewById(R.id.textView);
        text_view.setText(InitialNum);

        {
            // ACキー に イベントリスナーを設定する
            Button button = this.findViewById(R.id.button_ac);
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //Log.d("debug", "ここまで来た");
                    OnAcKey(v);
                }
            });
        }
        {
            // Cキー に イベントリスナーを設定する
            Button button = this.findViewById(R.id.button_c);
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //Log.d("debug", "ここまで来た");
                    OnCKey(v);
                }
            });
        }
        {
            // 1キー に イベントリスナーを設定する
            Button button = this.findViewById(R.id.button1);
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //Log.d("debug", "ここまで来た");
                    OnNumberKey(v, 1);
                }
            });
        }
        {
            // 2キー に イベントリスナーを設定する
            Button button = this.findViewById(R.id.button2);
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //Log.d("debug", "ここまで来た");
                    OnNumberKey(v, 2);
                }
            });
        }
        {
            // 3キー に イベントリスナーを設定する
            Button button = this.findViewById(R.id.button3);
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //Log.d("debug", "ここまで来た");
                    OnNumberKey(v, 3);
                }
            });
        }
        {
            // 4キー に イベントリスナーを設定する
            Button button = this.findViewById(R.id.button4);
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //Log.d("debug", "ここまで来た");
                    OnNumberKey(v, 4);
                }
            });
        }
        {
            // 5キー に イベントリスナーを設定する
            Button button = this.findViewById(R.id.button5);
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //Log.d("debug", "ここまで来た");
                    OnNumberKey(v, 5);
                }
            });
        }
        {
            // 6キー に イベントリスナーを設定する
            Button button = this.findViewById(R.id.button6);
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //Log.d("debug", "ここまで来た");
                    OnNumberKey(v, 6);
                }
            });
        }
        {
            // 7キー に イベントリスナーを設定する
            Button button = this.findViewById(R.id.button7);
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //Log.d("debug", "ここまで来た");
                    OnNumberKey(v, 7);
                }
            });
        }
        {
            // 8キー に イベントリスナーを設定する
            Button button = this.findViewById(R.id.button8);
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //Log.d("debug", "ここまで来た");
                    OnNumberKey(v, 8);
                }
            });
        }
        {
            // 9キー に イベントリスナーを設定する
            Button button = this.findViewById(R.id.button9);
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //Log.d("debug", "ここまで来た");
                    OnNumberKey(v, 9);
                }
            });
        }
        {
            // 0キー に イベントリスナーを設定する
            Button button = this.findViewById(R.id.button0);
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //Log.d("debug", "ここまで来た");
                    OnNumberKey(v, 0);
                }
            });
        }
        {
            // .キー に イベントリスナーを設定する
            Button button = this.findViewById(R.id.button_dot);
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //Log.d("debug", "ここまで来た");
                    //OnNumberKey(v, 0);
                }
            });
        }
        {
            // +キー に イベントリスナーを設定する
            Button button = this.findViewById(R.id.button_plus);
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //Log.d("debug", "ここまで来た");
                    OnPlusKey(v);
                }
            });
        }
        {
            // -キー に イベントリスナーを設定する
            Button button = this.findViewById(R.id.button_subtract);
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //Log.d("debug", "ここまで来た");
                    OnSubtractKey(v);
                }
            });
        }
        {
            // ×キー に イベントリスナーを設定する
            Button button = this.findViewById(R.id.button_multiply);
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //Log.d("debug", "ここまで来た");
                    OnMultiplyKey(v);
                }
            });
        }
        {
            // ÷キー に イベントリスナーを設定する
            Button button = this.findViewById(R.id.button_divide);
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //Log.d("debug", "ここまで来た");
                    OnDivideKey(v);
                }
            });
        }
        {
            // =キー に イベントリスナーを設定する
            Button button = this.findViewById(R.id.button_equal);
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //Log.d("debug", "ここまで来た");
                    OnEqualKey(v);
                }
            });
        }
    }

    /**
     * 数字キーをクリックされた時の処理
     *
     * @param v
     * @param num
     **/
    public void OnNumberKey(View v, int num) {
        // テキストビューを取得（出力先）
        TextView text_view = this.findViewById(R.id.textView);

        // 現在の入力文字列を取得
        CharSequence current_text = text_view.getText();
//        Log.d("debug", current_text.toString());
        String current_text_string = current_text.toString();

        // 現在の入力文字列が"0"（初期値） または 演算子キー後の最初の数字キーだったら一旦全削除する
        if (current_text_string.equalsIgnoreCase(this.InitialNum) ||
                this.IsWaitFirstNum == true) {
//            Log.d("debug", String.format("ここまで来た"));
            text_view.setText("");
            current_text_string = "";
            this.IsWaitFirstNum = false;

            CalculatorCore.TypedFirstNum();
            /*
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

            */
        }

        // 最後の文字が'.'だったらそれを一時削除
        int text_length = current_text_string.length();
        char[] current_text_chararray = current_text_string.toCharArray();
//        // デバッグ ここから
//        if (text_length > 0) {
//            Log.d("debug", String.format("レングス 1以上"));
//            Log.d("debug", String.format("%d 番目の文字 : %c", text_length - 1, current_text_chararray[text_length - 1]));
//        }
//        // デバッグ ここまで
        String carry_over_text;
        if (text_length > 0 && current_text_chararray[text_length - 1] == '.') {
            carry_over_text = current_text_string.substring(0, text_length - 1);
        } else {
            carry_over_text = current_text_string;
        }

        // 今入力された数字を最後に追加して、更に'.'を再度追加
        //carry_over_text = carry_over_text + String.format("%d", num) + ".";
        carry_over_text = carry_over_text + String.format("%d", num);
        text_view.setText(carry_over_text);
    }

    /**
     * +キーをタップされた時の処理
     * @param v
     */
    public void OnPlusKey(View v) {
        // 計算を実行する
        this.ExecuteCalculate(v);

        KeepInNumBuffer(v);
        // 計算モードを設定する
        this.Mode = AppMode.Remembered;
        this.PreviousMode = AppMode.None;
        {
            StackTraceElement throwableStackTraceElement = new Throwable().getStackTrace()[0];
            Log.d("debug", String.format("%s#%s(%s) ", throwableStackTraceElement.getClassName(), throwableStackTraceElement.getMethodName(), throwableStackTraceElement.getLineNumber())
                    + String.format("Mode=%s, NumBuffer=%f", this.Mode, this.NumBuffer));
        }

        // 次の最初の数字を待つ
        this.IsWaitFirstNum = true;
        // 計算モードを設定する
        this.Mode = AppMode.Add;
        this.PreviousMode = AppMode.None;
        {
            StackTraceElement throwableStackTraceElement = new Throwable().getStackTrace()[0];
            Log.d("debug", String.format("%s#%s(%s) ", throwableStackTraceElement.getClassName(), throwableStackTraceElement.getMethodName(), throwableStackTraceElement.getLineNumber())
                    + String.format("Mode=%s, NumBuffer=%f", this.Mode, this.NumBuffer));
        }
    }

    /**
     * -キーをタップされた時の処理
     * @param v
     */
    public void OnSubtractKey(View v) {
        // 計算を実行する
        this.ExecuteCalculate(v);

        KeepInNumBuffer(v);
        // 計算モードを設定する
        this.Mode = AppMode.Remembered;
        this.PreviousMode = AppMode.None;
        {
            StackTraceElement throwableStackTraceElement = new Throwable().getStackTrace()[0];
            Log.d("debug", String.format("%s#%s(%s) ", throwableStackTraceElement.getClassName(), throwableStackTraceElement.getMethodName(), throwableStackTraceElement.getLineNumber())
                    + String.format("Mode=%s, NumBuffer=%f", this.Mode, this.NumBuffer));
        }

        // 次の最初の数字を待つ
        this.IsWaitFirstNum = true;
        // 計算モードを設定する
        this.Mode = AppMode.Subtract;
        this.PreviousMode = AppMode.None;
        {
            StackTraceElement throwableStackTraceElement = new Throwable().getStackTrace()[0];
            Log.d("debug", String.format("%s#%s(%s) ", throwableStackTraceElement.getClassName(), throwableStackTraceElement.getMethodName(), throwableStackTraceElement.getLineNumber())
                    + String.format("Mode=%s, NumBuffer=%f", this.Mode, this.NumBuffer));
        }
    }

    /**
     * ×キーをタップされた時の処理
     * @param v
     */
    public void OnMultiplyKey(View v) {
        // 計算を実行する
        this.ExecuteCalculate(v);

        KeepInNumBuffer(v);
        // 計算モードを設定する
        this.Mode = AppMode.Remembered;
        this.PreviousMode = AppMode.None;
        {
            StackTraceElement throwableStackTraceElement = new Throwable().getStackTrace()[0];
            Log.d("debug", String.format("%s#%s(%s) ", throwableStackTraceElement.getClassName(), throwableStackTraceElement.getMethodName(), throwableStackTraceElement.getLineNumber())
                    + String.format("Mode=%s, NumBuffer=%f", this.Mode, this.NumBuffer));
        }

        // 次の最初の数字を待つ
        this.IsWaitFirstNum = true;
        // 計算モードを設定する
        this.Mode = AppMode.Multiply;
        this.PreviousMode = AppMode.None;
        {
            StackTraceElement throwableStackTraceElement = new Throwable().getStackTrace()[0];
            Log.d("debug", String.format("%s#%s(%s) ", throwableStackTraceElement.getClassName(), throwableStackTraceElement.getMethodName(), throwableStackTraceElement.getLineNumber())
                    + String.format("Mode=%s, NumBuffer=%f", this.Mode, this.NumBuffer));
        }
    }

    /**
     * ÷キーをタップされた時の処理
     * @param v
     */
    public void OnDivideKey(View v) {
        // 計算を実行する
        this.ExecuteCalculate(v);

        KeepInNumBuffer(v);
        // 計算モードを設定する
        this.Mode = AppMode.Remembered;
        this.PreviousMode = AppMode.None;
        {
            StackTraceElement throwableStackTraceElement = new Throwable().getStackTrace()[0];
            Log.d("debug", String.format("%s#%s(%s) ", throwableStackTraceElement.getClassName(), throwableStackTraceElement.getMethodName(), throwableStackTraceElement.getLineNumber())
                    + String.format("Mode=%s, NumBuffer=%f", this.Mode, this.NumBuffer));
        }

        // 次の最初の数字を待つ
        this.IsWaitFirstNum = true;
        // 計算モードを設定する
        this.Mode = AppMode.Divide;
        this.PreviousMode = AppMode.None;
        {
            StackTraceElement throwableStackTraceElement = new Throwable().getStackTrace()[0];
            Log.d("debug", String.format("%s#%s(%s) ", throwableStackTraceElement.getClassName(), throwableStackTraceElement.getMethodName(), throwableStackTraceElement.getLineNumber())
                    + String.format("Mode=%s, NumBuffer=%f", this.Mode, this.NumBuffer));
        }
    }


    /**
     * =キーをタップされた時の処理
     * @param v
     */
    public void OnEqualKey(View v) {
        // 計算を実行する
        this.ExecuteCalculate(v);

        // 後始末
        NumBuffer = Float.parseFloat(InitialNum);
        // 次の最初の数字を待つ
        this.IsWaitFirstNum = true;

        // 計算モードを設定する
        this.Mode = AppMode.None;
        this.PreviousMode = AppMode.None;
        {
            StackTraceElement throwableStackTraceElement = new Throwable().getStackTrace()[0];
            Log.d("debug", String.format("%s#%s(%s) ", throwableStackTraceElement.getClassName(), throwableStackTraceElement.getMethodName(), throwableStackTraceElement.getLineNumber())
                    + String.format("Mode=%s, NumBuffer=%f", this.Mode, this.NumBuffer));
        }
    }

    /**
     * ACキーをタップされた時の処理
     * @param v
     */
    public void OnAcKey(View v) {
        // テキストビューを取得（出力先）
        TextView text_view = this.findViewById(R.id.textView);
        text_view.setText(this.InitialNum);

        this.NumBuffer = 0;
        this.Mode = AppMode.None;
        this.PreviousMode = AppMode.None;
        {
            StackTraceElement throwableStackTraceElement = new Throwable().getStackTrace()[0];
            Log.d("debug", String.format("%s#%s(%s) ", throwableStackTraceElement.getClassName(), throwableStackTraceElement.getMethodName(), throwableStackTraceElement.getLineNumber())
                    + String.format("Mode=%s, NumBuffer=%f", this.Mode, this.NumBuffer));
        }
        this.IsWaitFirstNum = false;
    }

    /**
     * ACキーをタップされた時の処理
     * @param v
     */
    public void OnCKey(View v) {
        // テキストビューを取得（出力先）
        TextView text_view = this.findViewById(R.id.textView);
        text_view.setText(this.InitialNum);

        if (this.Mode != AppMode.None && this.Mode != AppMode.Remembered) {
            //*** 第二値を待っている ***

            // 覚えている第一値をクリア
            //this.NumBuffer = 0;

            // 次の最初の数字を待つ
            this.IsWaitFirstNum = true;
            // 計算モードを設定する
            AppMode previous = this.Mode;
            this.Mode = AppMode.Remembered;
            this.PreviousMode = previous;
            {
                StackTraceElement throwableStackTraceElement = new Throwable().getStackTrace()[0];
                Log.d("debug", String.format("%s#%s(%s) ", throwableStackTraceElement.getClassName(), throwableStackTraceElement.getMethodName(), throwableStackTraceElement.getLineNumber())
                        + String.format("Mode=%s, NumBuffer=%f", this.Mode, this.NumBuffer));
            }
        } else {
            //*** 第一値を待っている ***

            // 覚えている第一値をクリア
            this.NumBuffer = 0;

            // 次の最初の数字を待つ
            this.IsWaitFirstNum = true;
            // 計算モードを設定する
            this.Mode = AppMode.None;
            this.PreviousMode = AppMode.None;
            {
                StackTraceElement throwableStackTraceElement = new Throwable().getStackTrace()[0];
                Log.d("debug", String.format("%s#%s(%s) ", throwableStackTraceElement.getClassName(), throwableStackTraceElement.getMethodName(), throwableStackTraceElement.getLineNumber())
                        + String.format("Mode=%s, NumBuffer=%f", this.Mode, this.NumBuffer));
            }
        }
    }

    /**
     * @param num
     */
    public void KeepInNumBuffer(View v) {
        // テキストボックスの値を取得
        float input_num = this.TransportInputNum(v);

        //this.NumBuffer = this.NumBuffer + input_num;
        this.NumBuffer = input_num;
    }

    /**
     * テキストボックスに入力されている文字列を数値に変換する
     * @return
     */
    public float TransportInputNum(View v) {
        // テキストビューを取得（出力先）
        TextView text_view = this.findViewById(R.id.textView);

        // 現在の入力文字列を取得
        CharSequence current_text = text_view.getText();
        String current_text_string = current_text.toString();

        // 最後の文字が'.'だったらそれを一時削除
        int text_length = current_text_string.length();
        char[] current_text_chararray = current_text_string.toCharArray();
        String carry_over_text;
        if (text_length > 0 && current_text_chararray[text_length - 1] == '.') {
            carry_over_text = current_text_string.substring(0, text_length - 1);
        } else {
            carry_over_text = current_text_string;
        }

        float input_num = Float.parseFloat(carry_over_text);

        return input_num;
    }

    /**
     * 計算を実行する
     * @param v
     */
    public void ExecuteCalculate(View v) {
        // 一文字目の入力まち
        if (this.IsWaitFirstNum) {
            return;
        }
        // テキストボックスの値を取得
        float input_num = this.TransportInputNum(v);

        // 計算実行
        float result = CalculatorCore.Calculate(input_num);

        // 計算結果を表示
        this.OutputToTextBox(v, result);

        /*
        // モードを見て計算を実行する
        switch (this.Mode) {
            case Add:
                // 足し算を実行する
                CalculateAdd(v);
                break;
            case Subtract:
                // 引き算を実行する
                CalculateSubtract(v);
                break;
            case Multiply:
                // 掛け算を実行する
                CalculateMultiply(v);
                break;
            case Divide:
                // 割り算を実行する
                CalculateDivide(v);
                break;
            default:
                break;
        }

         */
    }

//    /**
//     * 足し算を実行する
//     * @param v
//     */
//    public void CalculateAdd(View v) {
//        // テキストボックスの値を取得
//        float input_num = this.TransportInputNum(v);
//
//        // 計算
//        this.NumBuffer = this.NumBuffer + input_num;
//
//        // 計算結果を表示
//        this.OutputToTextBox(v);
//    }
//
//    /**
//     * 引き算を実行する
//     * @param v
//     */
//    public void CalculateSubtract(View v) {
//        // テキストボックスの値を取得
//        float input_num = this.TransportInputNum(v);
//
//        // 計算
//        this.NumBuffer = this.NumBuffer - input_num;
//
//        // 計算結果を表示
//        this.OutputToTextBox(v);
//    }
//
//    /**
//     * 掛け算を実行する
//     * @param v
//     */
//    public void CalculateMultiply(View v) {
//        // テキストボックスの値を取得
//        float input_num = this.TransportInputNum(v);
//
//        // 計算
//        this.NumBuffer = this.NumBuffer * input_num;
//
//        // 計算結果を表示
//        this.OutputToTextBox(v);
//    }
//
//    /**
//     * 割り算を実行する
//     * @param v
//     */
//    public void CalculateDivide(View v) {
//        // テキストボックスの値を取得
//        float input_num = this.TransportInputNum(v);
//
//        // 計算
//        this.NumBuffer = this.NumBuffer / input_num;
//
//        // 計算結果を表示
//        this.OutputToTextBox(v);
//    }

    /**
     * 計算結果を表示
     * @param v
     */
    public void OutputToTextBox(View v, float input_num) {
        // テキストビューを取得（出力先）
        TextView text_view = this.findViewById(R.id.textView);

        // 今入力された数字を最後に追加して、更に'.'を再度追加
        float remainder = input_num % 1;

        if (remainder == 0) {
            // 整数の場合
            int num_integer = (int)input_num;
            //String output_text = String.format("%d", num_integer) + ".";
            String output_text = String.format("%d", num_integer);
            text_view.setText(output_text);
        } else {
            // 少数の場合
            float num_float = input_num;
            //String output_text = String.format("%d", num_integer) + ".";
            String output_text = String.format("%f", num_float);
            text_view.setText(output_text);
        }

        /*
        // 今入力された数字を最後に追加して、更に'.'を再度追加
        float remainder = this.NumBuffer % 1;

        if (remainder == 0) {
            // 整数の場合
            int num_integer = (int) this.NumBuffer;
            //String output_text = String.format("%d", num_integer) + ".";
            String output_text = String.format("%d", num_integer);
            text_view.setText(output_text);
        } else {
            // 少数の場合
            float num_float = this.NumBuffer;
            //String output_text = String.format("%d", num_integer) + ".";
            String output_text = String.format("%f", num_float);
            text_view.setText(output_text);
        }

         */
    }
}
