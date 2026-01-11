package com.openfit.Services;

import android.content.Context;
import android.content.res.Resources;

public abstract class BaseService {
    protected final Context context;
    protected final Resources res;
    public BaseService(Context context) {
        this.context = context;
        this.res = context.getResources();
    }

    protected String getResourceStringDefaultToKey(String key) {
        if(key == null) return "";
        int resId = res.getIdentifier(key, "string", context.getPackageName());
        return resId == 0 ? key : res.getText(resId).toString();
    }
}
