package com.xproject.util;

import com.xproject.videoplus.R;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.Gravity;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Utils of dialog.<br>
 * CN:�Ի����׼���
 */
public class DialogUtils
{

    static Context mContext = null;

    public static void setCurContext(Context context)
    {
        mContext = context;
    }

    /**
     * Show message in dialog.<br>
     * CN:��ʾ�Ի���
     * @param ctx - ������
     * @param title - ����
     * @param msg - ��Ϣ
     * @param listener - ����¼�����
     */
    public static void showDialog(Context ctx, String title, String msg,
        DialogInterface.OnClickListener listener)
    {
        if (ctx == null)
        {
            return;
        }

        String enterOk = mContext.getResources().getString(R.string.OK);
        AlertDialog.Builder builder = new Builder(ctx);

        builder.setTitle(title);
        builder.setMessage(msg);
        builder.setPositiveButton(enterOk, listener);
        builder.setCancelable(true);
        AlertDialog dialog = builder.create();
        dialog.setCanceledOnTouchOutside(false);
        dialog.show();
    }

    /**
     * Show message in menu dialog.<br>
     * CN:��ʾ�˵��Ի���
     * @param ctx - ������
     * @param title - ����
     * @param items - �˵���
     * @param listener - ����¼�����
     */
    public static void showMenuDialog(Context ctx, String title, String[] items,
        DialogInterface.OnClickListener listener)
    {
        if (ctx == null)
        {
            return;
        }

        AlertDialog.Builder builder = new AlertDialog.Builder(ctx);
        builder.setTitle(title).setItems(items, listener);
        builder.create().show();
    }

    /**
     * Show message in progress dialog.<br>
     * CN:��ʾ���ȶԻ���
     * @param ctx - ������
     * @param title - ����
     * @param msg - ��Ϣ
     * @return - ���ȶԻ���
     */
    public static ProgressDialog showProgressDialog(Context ctx, String title, String msg)
    {
        if (ctx == null)
        {
            return null;
        }

        ProgressDialog pd = new ProgressDialog(ctx);
        pd.setTitle(title);
        pd.setCancelable(true);
        pd.setMessage(msg);
        pd.show();
        return pd;
    }

    /**
     * Show message in toast.<br>
     * CN:��ʾ��ʾ��Ϣ��
     * @param message - ��ʾ��Ϣ
     * @param ctx - ������
     */
    public static void showToast(String message, Context ctx)
    {
        if (ctx == null)
        {
            return;
        }

        FrameLayout frameLayout = new FrameLayout(ctx);
        LinearLayout linearLayout = new LinearLayout(ctx);
        TextView textView = new TextView(ctx);
        linearLayout.setOrientation(LinearLayout.HORIZONTAL);
        textView.setGravity(Gravity.CENTER_VERTICAL);
        textView.setText(message);
        linearLayout.addView(textView, new LinearLayout.LayoutParams(LayoutParams.WRAP_CONTENT,
            LayoutParams.WRAP_CONTENT));
        frameLayout.addView(linearLayout, new LinearLayout.LayoutParams(LayoutParams.FILL_PARENT,
            LayoutParams.WRAP_CONTENT));
        frameLayout.setBackgroundResource(android.R.drawable.toast_frame);
        Toast toast = new Toast(ctx);
        toast.setView(frameLayout);
        toast.setDuration(Toast.LENGTH_SHORT);
        toast.show();
    }

    /**
     * Show message in toast.<br>
     * CN:��ʾ��ʾ��Ϣ��
     * @param msgId - ��ʾ��Ϣ
     * @param ctx - ������
     */
    public static void showToast(int msgId, Context ctx)
    {
        if (ctx == null)
        {
            return;
        }

        FrameLayout frameLayout = new FrameLayout(ctx);
        LinearLayout linearLayout = new LinearLayout(ctx);
        TextView textView = new TextView(ctx);
        linearLayout.setOrientation(LinearLayout.HORIZONTAL);
        textView.setGravity(Gravity.CENTER_VERTICAL);
        textView.setText(msgId);
        linearLayout.addView(textView, new LinearLayout.LayoutParams(LayoutParams.WRAP_CONTENT,
            LayoutParams.WRAP_CONTENT));
        frameLayout.addView(linearLayout, new LinearLayout.LayoutParams(LayoutParams.FILL_PARENT,
            LayoutParams.WRAP_CONTENT));
        frameLayout.setBackgroundResource(android.R.drawable.toast_frame);
        Toast toast = new Toast(ctx);
        toast.setView(frameLayout);
        toast.setDuration(Toast.LENGTH_SHORT);
        toast.show();
    }

    /**
     * Show message in dialog that can be canceled on touch out side.<br>
     * CN:���û������˳���ť����ʾ�˶Ի��򣨴��������ط���ȡ������
     * @param ctx - CN:������
     * @param title - CN:����
     * @param msg - CN:��Ϣ
     * @param okListener - CN:���OK�¼�����
     * @param dismissListener - CN:�Ի�����ʧ������
     */
    public static void showOutsideCancelDialog(Context ctx, String title, String msg,
        DialogInterface.OnClickListener okListener,
        DialogInterface.OnDismissListener dismissListener)
    {
        if (ctx == null)
        {
            return;
        }

        String enterOk = mContext.getResources().getString(R.string.dialogOK);
        AlertDialog.Builder builder = new Builder(ctx);

        builder.setTitle(title);
        builder.setMessage(msg);
        builder.setPositiveButton(enterOk, okListener);
        AlertDialog dialog = builder.create();
        dialog.setOnDismissListener(dismissListener);
        dialog.setCanceledOnTouchOutside(true);
        dialog.show();
    }

    /**
     * Show message in dialog that can be canceled on touch out side.<br>
     * CN:���û������˳���ť����ʾ�˶Ի��򣨴��������ط���ȡ������
     * @param ctx - ������
     * @param titleId - ����
     * @param msgId - ��Ϣ
     * @param okListener - ���OK�¼�����
     */
    public static void showOutsideCancelDialog(Context ctx, int titleId, int msgId,
        DialogInterface.OnClickListener okListener)
    {
        if (ctx == null)
        {
            return;
        }

        String enterOk = mContext.getResources().getString(R.string.dialogOK);
        AlertDialog.Builder builder = new Builder(ctx);

        builder.setTitle(titleId);
        builder.setMessage(msgId);
        builder.setPositiveButton(enterOk, okListener);
        AlertDialog dialog = builder.create();
        dialog.setCanceledOnTouchOutside(true);
        dialog.show();
    }

    /**
     * Show message in dialog what can be canceled.<br>
     * CN:���û������˳���ť����ʾ�˶Ի��򣨿�ȡ������
     * @param ctx - ������
     * @param titleId - ����
     * @param msgId - ��Ϣ
     * @param okListener - ���OK�¼�����
     * @param cancleListener - ���Cancle�¼�����
     */
    public static void showCancelDialog(Context ctx, int titleId, int msgId,
        DialogInterface.OnClickListener okListener, DialogInterface.OnClickListener cancleListener)
    {
        if (ctx == null)
        {
            return;
        }

        String enterOk = mContext.getResources().getString(R.string.dialogOK);
        String enterCancle = mContext.getResources().getString(R.string.dialogCancel);
        AlertDialog.Builder builder = new Builder(ctx);

        builder.setTitle(titleId);
        builder.setMessage(msgId);
        builder.setPositiveButton(enterOk, okListener);
        builder.setNegativeButton(enterCancle, cancleListener);
        builder.setCancelable(true);
        AlertDialog dialog = builder.create();
        dialog.setCanceledOnTouchOutside(true);
        dialog.show();
    }

    /**
     * Show message in dialog which is not cancel able.<br>
     * CN:��ʾ����ȡ���Ի���
     * @param ctx - context
     * @param title - title of dialog
     * @param msg - message of dialog
     * @param listener - click listener
     */
    public static void showDialogNoCancelable(Context ctx, String title, String msg,
        DialogInterface.OnClickListener listener)
    {
        if (ctx == null)
        {
            return;
        }

        String enterOk = mContext.getResources().getString(R.string.OK);
        AlertDialog.Builder builder = new Builder(ctx);

        builder.setTitle(title);
        builder.setMessage(msg);
        builder.setPositiveButton(enterOk, listener);
        builder.setCancelable(false);
        AlertDialog dialog = builder.create();
        dialog.setCanceledOnTouchOutside(false);
        dialog.show();
    }

    /**
     * Show message in dialog which is not cancel able.<br>
     * CN:��ʾ����ȡ���Ի���
     * @param ctx - context
     * @param titleId - title Id of dialog
     * @param msgId - message Id of dialog
     * @param listener - click listener
     */
    public static void showDialogNoCancelable(Context ctx, int titleId, int msgId,
        DialogInterface.OnClickListener listener)
    {
        if (ctx == null)
        {
            return;
        }

        String enterOk = mContext.getResources().getString(R.string.OK);
        AlertDialog.Builder builder = new Builder(ctx);

        builder.setTitle(titleId);
        builder.setMessage(msgId);
        builder.setPositiveButton(enterOk, listener);
        builder.setCancelable(false);
        AlertDialog dialog = builder.create();
        dialog.setCanceledOnTouchOutside(false);
        dialog.show();
    }
}
