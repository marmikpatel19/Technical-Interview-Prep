class CarFleet {
    /**
    We can iterate through the cars and each car check if it collides with the one
    ahead of it (by comparing times they would reach the end). If it does, then we 
    remove that car (since it becomes one fleet). At the end, we can count the number of fleets left. 

    We'd need to iterate backwards (from the right) and maintain the right-most car
    during mergining because the left-most car is meant to slow down to match the speed
    of the right-most car. 

    Since we need to iterate in order, we need to sort the cars. 
     */

    // time: O(nlogn), space: O(n)
    public int carFleet(int target, int[] position, int[] speed) {
        ArrayList<Pair<Integer, Integer>> cars = new ArrayList<>(); // tuple is (position, speed)

        // add in all cars
        for(int i = 0; i < position.length; i++){
            cars.add(new Pair<Integer, Integer>(position[i], speed[i]));
        }

        // sort cars
        Collections.sort(cars, new Comparator<Pair<Integer, Integer>>() {
            public int compare(Pair<Integer, Integer> p1, Pair<Integer, Integer> p2){
                return Integer.compare(p1.getKey(), p2.getKey());
            }
        });

        Pair<Integer, Integer> lastCar = cars.get(position.length - 1);
        double currArrivalTime = ((double)target - (double)lastCar.getKey()) / (double)lastCar.getValue();
        for(int i = position.length - 2; i >= 0; i--){
            Pair<Integer, Integer> car = cars.get(i);
            double arrivalTime = ((double)target - (double)car.getKey()) / (double)car.getValue();

            if(arrivalTime <= currArrivalTime){
                cars.remove(i);
            }else{
                currArrivalTime = arrivalTime;
            }
        }

        return cars.size();
    }
}