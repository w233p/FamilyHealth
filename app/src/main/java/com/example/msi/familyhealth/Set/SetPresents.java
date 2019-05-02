package com.example.msi.familyhealth.Set;

import com.baidu.trace.LBSTraceClient;
import com.baidu.trace.Trace;
import com.baidu.trace.model.OnTraceListener;
import com.baidu.trace.model.PushMessage;
import com.example.msi.familyhealth.MvpBase.*;

import java.util.List;

public class SetPresents extends BasePresenter<SetContacts.ISetView> implements SetContacts.ISetPresenter {
    private SetModel setModel = new SetModel();
    private OnTraceListener mTraceListener = null;
    private LBSTraceClient mTraceClient;
    private Trace mTrace;

    public SetPresents(SetContacts.ISetView view) {
        super(view);
    }

    @Override
    public List<String> getSetListDataItem() {
        return setModel.initSetListDataItem();
    }

    @Override
    public void addMemberClick(String memberName, String phone) {
        if (setModel.addMember(memberName, phone)) {
            getView().showToast("添加成功！");
        }
    }


    @Override
    public String[] getMemberList() {
        return setModel.getMember();
    }

    @Override
    public String getPhoneNumber(int position) {
        return setModel.phoneNumber(position);
    }

    public void initTrace() {
        //轨迹服务id
        long serviceId = 212265;
        //设备标识
        String entityName = "wyp's phone";
        //初始化轨迹服务
        boolean isNeedObjectStorage = false;
        mTrace = new Trace(serviceId, entityName, isNeedObjectStorage);
        //初始化轨迹服务客户端
        mTraceClient = new LBSTraceClient(getView().getSelfActivity().getApplication().getApplicationContext());

        // 定位周期(单位0:秒)
        int gatherInterval = 20;
        // 打包回传周期(单位:秒)
        int packInterval = 120;
        // 设置定位和打包周期
        mTraceClient.setInterval(gatherInterval, packInterval);

        // 初始化轨迹服务监听器
        mTraceListener = new OnTraceListener() {
            @Override
            public void onBindServiceCallback(int i, String s) {

            }

            // 开启服务回调
            @Override
            public void onStartTraceCallback(int status, String message) {
            }

            // 停止服务回调
            @Override
            public void onStopTraceCallback(int status, String message) {
            }

            // 开启采集回调
            @Override
            public void onStartGatherCallback(int status, String message) {
            }

            // 停止采集回调
            @Override
            public void onStopGatherCallback(int status, String message) {
            }

            // 推送回调
            @Override
            public void onPushCallback(byte messageNo, PushMessage message) {
            }

            @Override
            public void onInitBOSCallback(int i, String s) {

            }
        };
    }

    @Override
    public void traceStart() {
        //开启服务
        mTraceClient.startTrace(mTrace, mTraceListener);
        //开启采集
        mTraceClient.startGather(mTraceListener);
    }

    @Override
    public void traceStop() {
        //关闭服务
        mTraceClient.stopTrace(mTrace, mTraceListener);
        //停止采集
        mTraceClient.stopGather(mTraceListener);
    }
}
