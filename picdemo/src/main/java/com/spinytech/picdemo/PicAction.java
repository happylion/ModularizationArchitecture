package com.spinytech.picdemo;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;

import com.linked.annotion.Action;
import com.spinytech.macore.MaAction;
import com.spinytech.macore.router.MaActionResult;
import com.spinytech.macore.router.RouterRequest;

/**
 * Created by wanglei on 2017/1/4.
 */
@Action(processName = "com.spinytech.maindemo:pic", providerName = "pic")
public class PicAction implements MaAction {
    @Override
    public boolean isAsync(Context context, RouterRequest requestData) {
        return false;
    }

    @Override
    public MaActionResult invoke(Context context, RouterRequest requestData) {
        String isBigString = (String) requestData.getData().get("is_big");
        boolean isBig = "1".equals(isBigString);
        if(context instanceof Activity){
            Intent i = new Intent(context, PicActivity.class);
            i.putExtra("is_big",isBig);
            context.startActivity(i);
        }else{
            Intent i = new Intent(context, PicActivity.class);
            i.putExtra("is_big",isBig);
            i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(i);
        }
        return new MaActionResult.Builder().code(MaActionResult.CODE_SUCCESS).msg("success").data("").result(new Date()).build();
    }

    @Override
    public String getName() {
        return "pic";
    }
}
