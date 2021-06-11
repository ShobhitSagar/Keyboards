package com.shobhitsagar.minimilitiakeyboard;

import android.inputmethodservice.InputMethodService;
import android.inputmethodservice.Keyboard;
import android.inputmethodservice.KeyboardView;
import android.media.AudioManager;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.InputConnection;

/**
 * Created by shobhitsagar on 14/09/17.
 */

public class MMkeyboard extends InputMethodService implements KeyboardView.OnKeyboardActionListener {
    private KeyboardView kv;
    private Keyboard keyboard;
    private boolean caps = false;
    @Override
    public View onCreateInputView() {
        kv = (KeyboardView) getLayoutInflater().inflate(R.layout.keyboard, null);
        keyboard = new Keyboard(this, R.xml.keyboard);
        kv.setKeyboard(keyboard);
        kv.setOnKeyboardActionListener(this);
        return kv;
    }
    private void playClick(int keyCode){
    }
    @Override
    public void onPress(int primaryCode) {
    }
    @Override
    public void onRelease(int primaryCode) {
    }
    @Override
    public void onKey(int primaryCode, int[] keyCodes) {
        InputConnection ic = getCurrentInputConnection();
        playClick(primaryCode);
        switch (primaryCode) {
            case Keyboard.KEYCODE_DELETE:
                ic.deleteSurroundingText(1, 0);
                break;
            case Keyboard.KEYCODE_SHIFT:
                caps = !caps;
                keyboard.setShifted(caps);
                kv.invalidateAllKeys();
                break;
            case Keyboard.KEYCODE_DONE:
                ic.sendKeyEvent(new KeyEvent(KeyEvent.ACTION_DOWN, KeyEvent.KEYCODE_ENTER));
                break;
            case 1:
                String BI = "BI";
                ic.commitText(String.valueOf(BI), 1);
                ic.sendKeyEvent(new KeyEvent(KeyEvent.ACTION_DOWN, KeyEvent.KEYCODE_ENTER));
                break;
            case 2:
                String LG = "LG";
                ic.commitText(String.valueOf(LG), 1);
                ic.sendKeyEvent(new KeyEvent(KeyEvent.ACTION_DOWN, KeyEvent.KEYCODE_ENTER));
                break;
            case 3:
                String RU = "RU";
                ic.commitText(String.valueOf(RU), 1);
                ic.sendKeyEvent(new KeyEvent(KeyEvent.ACTION_DOWN, KeyEvent.KEYCODE_ENTER));
                break;
            case 4:
                String GS = "GS";
                ic.commitText(String.valueOf(GS), 1);
                ic.sendKeyEvent(new KeyEvent(KeyEvent.ACTION_DOWN, KeyEvent.KEYCODE_ENTER));
                break;
            case 5:
                String NN = "NN";
                ic.commitText(String.valueOf(NN), 1);
                ic.sendKeyEvent(new KeyEvent(KeyEvent.ACTION_DOWN, KeyEvent.KEYCODE_ENTER));
                break;
            case 6:
                String HH = "HH";
                ic.commitText(String.valueOf(HH), 1);
                ic.sendKeyEvent(new KeyEvent(KeyEvent.ACTION_DOWN, KeyEvent.KEYCODE_ENTER));
                break;
            case 7:
                String CM = "CM";
                ic.commitText(String.valueOf(CM), 1);
                ic.sendKeyEvent(new KeyEvent(KeyEvent.ACTION_DOWN, KeyEvent.KEYCODE_ENTER));
                break;
            case 8:
                String CB = "CB";
                ic.commitText(String.valueOf(CB), 1);
                ic.sendKeyEvent(new KeyEvent(KeyEvent.ACTION_DOWN, KeyEvent.KEYCODE_ENTER));
                break;
            case 9:
                String MO = "MO";
                ic.commitText(String.valueOf(MO), 1);
                ic.sendKeyEvent(new KeyEvent(KeyEvent.ACTION_DOWN, KeyEvent.KEYCODE_ENTER));
                break;
            case 10:
                String WP = "WP";
                ic.commitText(String.valueOf(WP), 1);
                ic.sendKeyEvent(new KeyEvent(KeyEvent.ACTION_DOWN, KeyEvent.KEYCODE_ENTER));
                break;
            case 11:
                String GG = "GG";
                ic.commitText(String.valueOf(GG), 1);
                ic.sendKeyEvent(new KeyEvent(KeyEvent.ACTION_DOWN, KeyEvent.KEYCODE_ENTER));
                break;
            case 12:
                String GM = "GM";
                ic.commitText(String.valueOf(GM), 1);
                ic.sendKeyEvent(new KeyEvent(KeyEvent.ACTION_DOWN, KeyEvent.KEYCODE_ENTER));
                break;
            case 13:
                String NS = "NS";
                ic.commitText(String.valueOf(NS), 1);
                ic.sendKeyEvent(new KeyEvent(KeyEvent.ACTION_DOWN, KeyEvent.KEYCODE_ENTER));
                break;
            case 32:
                String Space = " ";
                ic.commitText(String.valueOf(Space), 1);
                break;
            case 1101:
                keyboard = new Keyboard(this, R.xml.numsymbolshiftkeyboard);
                kv.setKeyboard(keyboard);
                kv.setOnKeyboardActionListener(this);
                break;
            case 14:
                keyboard = new Keyboard(this, R.xml.numsymbolkeyboard);
                kv.setKeyboard(keyboard);
                kv.setOnKeyboardActionListener(this);
                break;
            case 222:
                keyboard = new Keyboard(this, R.xml.simplekeyboard);
                kv.setKeyboard(keyboard);
                kv.setOnKeyboardActionListener(this);
                break;
            case 444:
                keyboard = new Keyboard(this, R.xml.keyboard);
                kv.setKeyboard(keyboard);
                kv.setOnKeyboardActionListener(this);
                break;
            default:
                char code = (char) primaryCode;
                if (Character.isLetter(code) && caps) {
                    code = Character.toUpperCase(code);
                    caps = !caps;
                    keyboard.setShifted(caps);
                    kv.invalidateAllKeys();
                }
                ic.commitText(String.valueOf(code), 1);
        }
    }
    @Override
    public void onText(CharSequence text) {
    }

    @Override
    public void swipeLeft() {
    }

    @Override
    public void swipeRight() {
    }

    @Override
    public void swipeDown() {
    }

    @Override
    public void swipeUp() {
    }
}
