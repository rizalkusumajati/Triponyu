package com.example.macmini2.triponyu;


import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.TextView;
import android.widget.Toast;

import com.github.sundeepk.compactcalendarview.CompactCalendarView;
import com.github.sundeepk.compactcalendarview.domain.CalendarDayEvent;
import com.prolificinteractive.materialcalendarview.CalendarDay;
import com.prolificinteractive.materialcalendarview.MaterialCalendarView;
import com.prolificinteractive.materialcalendarview.OnDateSelectedListener;
import com.prolificinteractive.materialcalendarview.OnMonthChangedListener;

import org.w3c.dom.Text;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;


/**
 * A simple {@link Fragment} subclass.
 */
public class CalendarAvailabilityFragment extends Fragment {

    private CalendarView calendar;
    CompactCalendarView compactCalendarView;
    private Calendar currentCalender = Calendar.getInstance(Locale.getDefault());
    MaterialCalendarView widget;
    private Button publish;

    private SimpleDateFormat dateFormatForMonth = new SimpleDateFormat("MMMM- yyyy", Locale.getDefault());
    private TextView monthYear;
    public CalendarAvailabilityFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_calendar_availability, container, false);
        ((IndexActivity)getActivity()).fragmentIndex=1;
        ((IndexActivity)getActivity()).setToolbarTitle("Add New Trip");
        publish=(Button)view.findViewById(R.id.step5);
        publish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              //  ((IndexActivity)getActivity()).gotoHome();
            }
        });
       // calendar = (CalendarView) view.findViewById(R.id.calendar);
        widget=(MaterialCalendarView)view.findViewById(R.id.calendarView);
//        compactCalendarView = (CompactCalendarView)view.findViewById(R.id.compactcalendar_view);
//        compactCalendarView.drawSmallIndicatorForEvents(true);
//        compactCalendarView.setUseThreeLetterAbbreviation(true);
       // monthYear=(TextView) view.findViewById(R.id.monthYear);
        Calendar calendar = Calendar.getInstance();
        widget.setSelectedDate(calendar.getTime());
        widget.setOnDateChangedListener(new OnDateSelectedListener() {
            @Override
            public void onDateSelected(@NonNull MaterialCalendarView widget, @NonNull CalendarDay date, boolean selected) {
                Toast.makeText(getContext(), "Date : " + date.getDate().toString(), Toast.LENGTH_SHORT).show();
            }
        });

        widget.setOnMonthChangedListener(new OnMonthChangedListener() {
            @Override
            public void onMonthChanged(MaterialCalendarView widget, CalendarDay date) {
                //monthYear.setText(dateFormatForMonth.format(date.getDate()));
            }
        });
        //compactCalendarView
        //set title on calendar scroll
//        compactCalendarView.setListener(new CompactCalendarView.CompactCalendarViewListener() {
//            @Override
//            public void onDayClick(Date dateClicked) {
//
//
//                Toast.makeText(getContext(), "Date : " + dateClicked.toString(), Toast.LENGTH_SHORT).show();
//
//            }
//
//            @Override
//            public void onMonthScroll(Date firstDayOfNewMonth) {
//                // Changes toolbar title on monthChange
//                monthYear.setText(dateFormatForMonth.format(firstDayOfNewMonth));
//
//            }
//
//        });

//        // sets whether to show the week number.
//
//        calendar.setShowWeekNumber(false);
//
//        // sets the first day of week according to Calendar.
//
//        // here we set Monday as the first day of the Calendar
//
//        calendar.setFirstDayOfWeek(2);
//
//        //The background color for the selected week.
//
//
//        calendar.setSelectedWeekBackgroundColor(getResources().getColor(R.color.green));
//
//        //sets the color for the dates of an unfocused month.
//
//        calendar.setUnfocusedMonthDateColor(getResources().getColor(R.color.blue));
//
//        //sets the color for the separator line between weeks.
//
//        calendar.setWeekSeparatorLineColor(getResources().getColor(R.color.cardview_dark_background));
//
//        //sets the color for the vertical bar shown at the beginning and at the end of the selected date.
//
//        calendar.setSelectedDateVerticalBar(R.color.cardview_light_background);
//
//        //sets the listener to be notified upon selected date change.
//
//        calendar.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
//            //show the selected date as a toast
//
//            @Override
//
//            public void onSelectedDayChange(CalendarView view, int year, int month, int day) {
//
//                Toast.makeText(getContext(), day + "/" + month + "/" + year, Toast.LENGTH_LONG).show();
//
//            }
//
//        });
   // addDummyEvents();
        return view;

    }

    // Adding dummy events in calendar view for April, may, june 2016
    private void addDummyEvents() {

        addEvents(compactCalendarView, Calendar.SEPTEMBER);
        addEvents(compactCalendarView, Calendar.OCTOBER);
        addEvents(compactCalendarView, Calendar.NOVEMBER);

        // Refresh calendar to update events
        compactCalendarView.invalidate();
    }

// Adding events from 1 to 6 days

    private void addEvents(CompactCalendarView compactCalendarView, int month) {
        currentCalender.setTime(new Date());
        currentCalender.set(Calendar.DAY_OF_MONTH, 1);
        Date firstDayOfMonth = currentCalender.getTime();
        for (int i = 0; i < 6; i++) {
            currentCalender.setTime(firstDayOfMonth);
            if (month > -1) {
                currentCalender.set(Calendar.MONTH, month);
            }
            currentCalender.add(Calendar.DATE, i);
            setToMidnight(currentCalender);
            compactCalendarView.addEvent(new CalendarDayEvent(currentCalender.getTimeInMillis(), Color.argb(255, 255, 255, 255)), false);
        }
    }
    private void setToMidnight(Calendar calendar) {
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
    }

    public void gotoToday() {

        // Set any date to navigate to particular date
        compactCalendarView.setCurrentDate(Calendar.getInstance(Locale.getDefault()).getTime());


    }

}
