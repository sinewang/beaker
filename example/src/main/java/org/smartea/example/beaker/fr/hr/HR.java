package org.smartea.example.beaker.fr.hr;

import org.smartea.example.beaker.fr.hr.entity.Order;
import org.smartea.example.beaker.fr.hr.dict.OrderStatus;
import org.smartea.example.beaker.fr.hr.form.OrderForm;
import org.smartea.example.beaker.fr.hr.reciept.OrderReceipt;
import wang.yanjiong.beaker.combi.cubes.sync.SyncCube;
import wang.yanjiong.beaker.combi.cubes.basic.api.Query;
import wang.yanjiong.beaker.combi.cubes.basic.api.Status;
import wang.yanjiong.beaker.combi.cubes.sync.api.pr.Process;
import wang.yanjiong.beaker.combi.cubes.sync.api.pr.Recall;

/**
 * Created by WangYanJiong on 11/10/16.
 */
@SyncCube
public interface HR {

    @Process
    OrderReceipt method1(OrderForm orderForm);

    @Recall
    Object method2(Object object);

    @Query
    Order method3(Object object);

    @Status
    OrderStatus method4(Object object);

}