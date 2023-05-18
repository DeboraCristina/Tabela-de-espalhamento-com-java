package ex02.model;

public class ResidentController
{
    Resident resident;

    public ResidentController()
    {
        this.resident = new Resident();
    }

    public int getNum_apartment()
    {
        return resident.num_apartment;
    }

    public void setNum_apartment(int num_apartment)
    {
        resident.num_apartment = num_apartment;
    }

    public String getName()
    {
        return resident.name;
    }

    public void setName(String name)
    {
        resident.name = name;
    }

    public Car getCar()
    {
        return resident.car;
    }

    public void setCar(String car_model, String car_color, String car_plate)
    {
        Car car = new Car();
        car.car_color = car_color;
        car.car_model = car_model;
        car.car_plate = car_plate;
        car.badge = resident.num_apartment;
        resident.car = car;
    }

    @Override
    public int hashCode() {
        String strNumApartment = Integer.toString(resident.num_apartment);
        int floor = (strNumApartment.charAt(0) - 48);
        if (strNumApartment.length() >= 4)
        {
            floor = floor * 10;
            floor = floor + (strNumApartment.charAt(1) - 48);
        }
        return floor - 1;
    }

    @Override
    public String toString() {
        StringBuilder residentInfo = new StringBuilder();
        residentInfo.append("Name: ").append(resident.name);
        residentInfo.append("; Apartment: ").append(resident.num_apartment);
        residentInfo.append("; Car Model: ").append(resident.car.car_model);
        residentInfo.append("; Car Color: ").append(resident.car.car_color);
        residentInfo.append("; Car Plate: ").append(resident.car.car_plate);
        return residentInfo.toString();
    }
}
