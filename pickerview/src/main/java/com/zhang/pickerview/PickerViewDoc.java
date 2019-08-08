package com.zhang.pickerview;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;

import com.bigkoo.pickerview.builder.OptionsPickerBuilder;
import com.bigkoo.pickerview.builder.TimePickerBuilder;
import com.bigkoo.pickerview.listener.OnOptionsSelectListener;
import com.bigkoo.pickerview.listener.OnTimeSelectListener;
import com.bigkoo.pickerview.view.OptionsPickerView;
import com.bigkoo.pickerview.view.TimePickerView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by zhangyuncai on 2019/8/8.
 * 三级联动文档
 */
public class PickerViewDoc {
    /**
     * 条件选择器
     *
     * @param context
     * @return
     */
    public static OptionsPickerView selectCondition(Context context) {
        final List<String> options1Items = new ArrayList();
        options1Items.add("男");
        options1Items.add("女");
        OptionsPickerView pvOptions = new OptionsPickerBuilder(context, new OnOptionsSelectListener() {
            @Override
            public void onOptionsSelect(int options1, int option2, int options3, View v) {
                //返回的分别是三个级别的选中位置
//                String tx = options1Items.get(options1).getPickerViewText()
//                        + options2Items.get(options1).get(option2)
//                        + options3Items.get(options1).get(option2).get(options3).getPickerViewText();
//                bt_main_condition.setText(options1Items.get(options1));
            }
        }).build();
        pvOptions.setPicker(options1Items);
        pvOptions.show();
        return pvOptions;
    }

    /**
     * 时间选择器
     *
     * @param context
     * @return
     */
    public static TimePickerView selectTime(Context context) {
        TimePickerView pvTime = new TimePickerBuilder(context, new OnTimeSelectListener() {
            @Override
            public void onTimeSelect(Date date, View v) {//选中事件回调
//                bt_main_time.setText(date.getTime() + "");
            }
        }).build();
        // pvTime.setDate(Calendar.getInstance());//注：根据需求来决定是否使用该方法（一般是精确到秒的情况），此项可以在弹出选择器的时候重新设置当前时间，避免在初始化之后由于时间已经设定，导致选中时间与当前时间不匹配的问题。
        pvTime.show();
        return pvTime;
    }


//    public class TimePickerHelper {
//
//        private static String CURRENT_TIME = "current_time";
//        private static String DEFUALT_START_TIME = "1900-01-01";
//        private static String DEFUALT_END_TIME = "2100-12-31";
//
//        public static TimePickerHelper getInstance() {
//            return new TimePickerHelper();
//        }
//
//        public TimePickerView getTimePickerDialog(Context context
//                , ViewGroup decorView
//                , String startDate
//                , String endDate
//                , String selectedDate
//                , boolean[] type
//                , OnTimeSelectListener listener) {
//            if (TextUtils.isEmpty(startDate)) {
//                startDate = DEFUALT_START_TIME;
//            }
//            if (TextUtils.isEmpty(endDate)) {
//                endDate = DEFUALT_END_TIME;
//            }
//            if (TextUtils.isEmpty(selectedDate)) {
//                selectedDate = CURRENT_TIME;
//            }
//
//            Calendar startDate1 = TextUtils.equals(startDate, CURRENT_TIME) ? Calendar.getInstance()
//                    : getCalendar(startDate, format_yyyy_MM_dd);
//            Calendar endDate1 = TextUtils.equals(endDate, CURRENT_TIME) ? Calendar.getInstance()
//                    : getCalendar(endDate, format_yyyy_MM_dd);
//            Calendar selectDate1 = TextUtils.equals(selectedDate, CURRENT_TIME) ? Calendar.getInstance()
//                    : getCalendar(selectedDate, format_yyyy_MM_dd);
//            return getTimePickerDialog(context, decorView, startDate1, endDate1, selectDate1, type, listener);
//        }
//
//        /**
//         * 自定义时间选择器,仅提供picker,不show,
//         *
//         * @param context
//         * @param decorView  在dialog中显示picker的根部容器
//         * @param startDate  开始时间，如需当前时间请传入常量CURRENT_TIME
//         * @param endDate    结束时间，如需当前时间请传入常量CURRENT_TIME
//         * @param selectDate 当前默认选中时间，如需当前时间请传入常量CURRENT_TIME
//         * @param listener
//         */
//        public TimePickerView getTimePickerDialog(Context context
//                , ViewGroup decorView
//                , Calendar startDate
//                , Calendar endDate
//                , Calendar selectDate
//                , boolean[] type
//                , OnTimeSelectListener listener) {
//            if (type == null) {
//                type = new boolean[]{true, true, true, false, false, false};
//            }
//
//            if (startDate == null) {
//                startDate = getCalendar(DEFUALT_START_TIME, format_yyyy_MM_dd);
//            }
//            if (endDate == null) {
//                endDate = getCalendar(DEFUALT_END_TIME, format_yyyy_MM_dd);
//            }
//            if (selectDate == null) {
//                endDate = Calendar.getInstance();
//            }
//
//            /**
//             * @description
//             *
//             * 注意事项：
//             * 1.自定义布局中，id为 optionspicker 或者 timepicker 的布局以及其子控件必须要有，否则会报空指针.
//             * 具体可参考demo 里面的两个自定义layout布局。
//             * 2.因为系统Calendar的月份是从0-11的,所以如果是调用Calendar的set方法来设置时间,月份的范围也要是从0-11
//             * setRangDate方法控制起始终止时间(如果不设置范围，则使用默认时间1900-2100年，此段代码可注释)
//             */
//
//            TimePickerBuilder builder = new TimePickerBuilder(context, listener);
//            if (decorView != null) {
//                builder.setDecorView(decorView);
//            }
//
//        /*.setType(TimePickerView.Type.ALL)//default is all
//        .setCancelText("Cancel")
//        .setSubmitText("Sure")
//        .setContentSize(18)
//        .setTitleSize(20)
//        .setTitleText("Title")
//        .setTitleColor(Color.BLACK)
//       /*.setDividerColor(Color.WHITE)//设置分割线的颜色
//        .setTextColorCenter(Color.LTGRAY)//设置选中项的颜色
//        .setLineSpacingMultiplier(1.6f)//设置两横线之间的间隔倍数
//        .setTitleBgColor(Color.DKGRAY)//标题背景颜色 Night mode
//        .setBgColor(Color.BLACK)//滚轮背景颜色 Night mode
//        .setSubmitColor(Color.WHITE)
//        .setCancelColor(Color.WHITE)*//*.gravity(Gravity.RIGHT)// default is center*///注释后默认时间1900-2100年
////                .setLayoutRes(R.layout.pickerview_custom_time,null)
////                                pvTime.returnData();
////                                pvTime.dismiss();
////                                pvTime.dismiss();
////是否只显示中间选中项的label文字，false则每项item全部都带有label。
////                .setDividerColor(Color.RED)
////                .isDialog(true)
//            TimePickerView pvTime = builder
//                    /*.setType(TimePickerView.Type.ALL)//default is all
//                    .setCancelText("Cancel")
//                    .setSubmitText("Sure")
//                    .setContentSize(18)
//                    .setTitleSize(20)
//                    .setTitleText("Title")
//                    .setTitleColor(Color.BLACK)
//                   /*.setDividerColor(Color.WHITE)//设置分割线的颜色
//                    .setTextColorCenter(Color.LTGRAY)//设置选中项的颜色
//                    .setLineSpacingMultiplier(1.6f)//设置两横线之间的间隔倍数
//                    .setTitleBgColor(Color.DKGRAY)//标题背景颜色 Night mode
//                    .setBgColor(Color.BLACK)//滚轮背景颜色 Night mode
//                    .setSubmitColor(Color.WHITE)
//                    .setCancelColor(Color.WHITE)*/
//                    /*.gravity(Gravity.RIGHT)// default is center*/
//                    .setDate(selectDate)
//                    .setRangDate(startDate, endDate)//注释后默认时间1900-2100年
////                .setLayoutRes(R.layout.pickerview_custom_time,null)
////                .setLayoutRes(R.layout.pickerview_custom_time, new CustomListener() {
////                    @Override
////                    public void customLayout(View v) {
////                        TextView tvSubmit = (TextView) v.findViewById(R.id.tv_finish);
////                        TextView ivCancel = (TextView) v.findViewById(R.id.iv_cancel);
////                        tvSubmit.setOnClickListener(new View.OnClickListener() {
////                            @Override
////                            public void onClick(View v) {
////                                pvTime.returnData();
////                                pvTime.returnData();
////                                pvTime.dismiss();
////                            }
////                        });
////                        ivCancel.setOnClickListener(new View.OnClickListener() {
////                            @Override
////                            public void onClick(View v) {
////                                pvTime.dismiss();
////                            }
////                        });
////                    }
////                })
//                    .setType(type)
//                    .isCenterLabel(false) //是否只显示中间选中项的label文字，false则每项item全部都带有label。
////                .setDividerColor(Color.RED)
//                    .isCyclic(false)
//                    .setOutSideCancelable(true)
////                .isDialog(true)
//                    .build();
//            return pvTime;
//
//        }
//
//
//        private static SimpleDateFormat format_yyyy_MM_dd = new SimpleDateFormat("yyyy-MM-dd");
//
//        /**
//         * @param strDate 时间格式的字符串 例如:2017年04月14日
//         * @param format  yyyy年MM月dd日
//         * @return Calendar
//         */
//        private static Calendar getCalendar(String strDate, SimpleDateFormat format) {
//            Date date = getDate(strDate, format);
//            Calendar c = Calendar.getInstance();
//            c.setTime(date);
//            return c;
//        }
//
//        /**
//         * 所有解析时间格式异常全丢在这里
//         *
//         * @param strDate 时间格式的字符串 例如:2017年04月14日
//         * @param format  yyyy年MM月dd日
//         * @return Date
//         */
//        private static Date getDate(String strDate, SimpleDateFormat format) {
//            try {
//                return format.parse(strDate);
//            } catch (ParseException e) {
//                e.printStackTrace();
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//            Calendar c = Calendar.getInstance();
//            return c.getTime();
//        }
//
//
//    }
}
