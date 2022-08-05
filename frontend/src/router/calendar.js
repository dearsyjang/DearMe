import CalendarView from '@/views/calendar/CalendarView.vue'
import DayComp from '@/views/calendar/components/DayComp'
export default [
    {
        path: '/calendar',
        name: 'calendar',
        component: CalendarView
      },
      {
        path: '/calendar/dayComp',
        name: 'calendarDay',
        component: DayComp
      },

    
  ]