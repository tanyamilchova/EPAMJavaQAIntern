package edu.epam.fop.lambdas.kamino;

import edu.epam.fop.lambdas.kamino.equipment.Equipment;
import edu.epam.fop.lambdas.kamino.equipment.EquipmentFactory;

import java.util.Iterator;

public class BatchPolicies {

  public interface BatchPolicy {

    CloneTrooper[] formBatchOf(CloneTrooper base, int count);
  }

  public static BatchPolicy getCodeAwarePolicy(String codePrefix, int codeSeed) {
      return (base, count) ->{
        long code=codeSeed;
        CloneTrooper[]cloneTroopers=new CloneTrooper[count];
        for (int i = 0; i < count; i++) {
          CloneTrooper trooper=new CloneTrooper(String.format(codePrefix+ "-%04d",code++));
          trooper.setNickname(base.getNickname());
          trooper.setEquipment(base.getEquipment());
          cloneTroopers[i]=trooper;
        }
        return cloneTroopers;
      };
  }

  public static BatchPolicy addNicknameAwareness(Iterator<String> nicknamesIterator, BatchPolicy policy) {
    return ((base, count) -> {
      CloneTrooper[] troopers = policy.formBatchOf(base, count);
      for (int i = 0; i < troopers.length && nicknamesIterator.hasNext(); i++) {
        troopers[i].setNickname(nicknamesIterator.next());
      }
      return troopers;
    });
  }
  public static BatchPolicy addEquipmentOrdering(Equipment equipmentExample, BatchPolicy policy) {
    // TODO write your code here
    return ((base, count) -> {
      CloneTrooper[]troopers= policy.formBatchOf(base, count);
      for (CloneTrooper trooper:troopers){
        trooper.setEquipment(EquipmentFactory.orderTheSame(equipmentExample));
      }
      return troopers;
    });
  }
}
