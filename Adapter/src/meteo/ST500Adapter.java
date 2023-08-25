package meteo;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class ST500Adapter extends ST500Info implements MeteoSensor{

    @Override
    public int getId() {
        return getData().identifier();
    }

    @Override
    public Float getTemperature() {
        return (float) getData().temperature();
    }

    @Override
    public Float getHumidity() {
        return 0.0f;
    }

    @Override
    public Float getPressure() {
        return 0.0f;
    }

    @Override
    public LocalDateTime getDateTime() {
        int year=getData().year();
        int day = getData().day();
        int month=1;
        for (int i=1;i<=12;i++){
            LocalDate date=LocalDate.of(getData().year(),i,1);
            if (day>date.lengthOfMonth()){
                day-=date.lengthOfMonth();
            } else {
                month=i;
                break;
            }
        }
        int hour = getData().second()/3600;
        int minute = (getData().second()-hour*3600)/60;
        int second=getData().second()-hour*3600-minute*60;
        return LocalDateTime.of(year,month,day,hour,minute,second);
    }
}
