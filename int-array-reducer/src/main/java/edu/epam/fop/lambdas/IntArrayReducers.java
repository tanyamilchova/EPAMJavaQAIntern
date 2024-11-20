package edu.epam.fop.lambdas;

import java.util.ArrayList;
public interface IntArrayReducers {

  static IntArrayReducer SUMMARIZER = array -> {
    int sum=0;
    for (int num:array){
      sum+=num;
    }
    return sum;
  };

  static IntArrayReducer MULTIPLIER = array -> {
    int multiplication=1;
    for (int num:array){
      multiplication*=num;
    }
    return multiplication;
  };

  static IntArrayReducer MIN_FINDER = array -> {
    int min=Integer.MAX_VALUE;
    for (int num : array){
      if(num<min){
        min=num;
      }
    }
    return min;
  };

  static IntArrayReducer MAX_FINDER = array -> {
    int max=Integer.MIN_VALUE;
    for (int num : array){
      if(num > max){
        max = num;
      }
    }
    return max;
  };

  static IntArrayReducer AVERAGE_CALCULATOR = array -> {
    int sum=0;
    for (int num:array){
      sum+=num;
    }
    double avg=(double) sum / array.length;
    return (int) Math.round(avg);
  };

  static IntArrayReducer UNIQUE_COUNTER = array -> {
    ArrayList<Integer>unuques= new ArrayList<>();
    for (int num: array){
      boolean contains = false;
      for (int i = 0; i < unuques.size(); i++) {
        if(num == unuques.get(i)){
          contains=true;
          break;
        }
      }
      if( ! contains){
        unuques.add(num);
      }
    }
   return unuques.size();
  };

  static IntArrayReducer SORT_DIRECTION_DEFINER = array -> {
    ArrayList<Integer>originalArrayList=new ArrayList<>();
    ArrayList<Integer> copyList = new ArrayList<>();


    for(int num : array){
      originalArrayList.add(num);
      copyList.add(num);
    }

    copyList.sort(Integer::compareTo);
    if(originalArrayList.equals(copyList)){
      if(UNIQUE_COUNTER.reduce(array) == 1){
        return 0;
      }else {
        return 1;
      }
    }else {
      copyList.sort((o1, o2) -> o2-o1 );
      if(originalArrayList.equals(copyList)){
        return -1;
      }else {
          return 0;
        }
      }
  };
}
