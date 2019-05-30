import edu.iis.mto.time.TimeData;
import edu.iis.mto.time.Order;
import edu.iis.mto.time.OrderExpiredException;
import edu.iis.mto.time.OrderStateException;
import org.joda.time.DateTime;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;

public class OrderTest {

    private Order order;
    private TimeData timeData;

    @Before
    public void init() {
        timeData = new TimeData();
        order = new Order(timeData);
    }


    @Test(expected = OrderExpiredException.class)
    public void OrderTestWhenOrderIsCanceled() {
        timeData.setTime(new DateTime(2019, 5, 27, 10, 0));
        order.submit();
        timeData.setTime(new DateTime(2019, 5, 28, 11, 0));
        order.confirm();
    }

    @Test
    public void OrderTestWhenOrderIsSubmitted() {
        timeData.setTime(new DateTime(2019, 5, 27, 10, 0));
        order.submit();
        Assert.assertThat(order.getOrderState(), is(Order.State.SUBMITTED));
    }

    @Test
    public void OrderTestWhenOrderIsCreated() {
        Assert.assertThat(order.getOrderState(), is(Order.State.CREATED));
    }

    @Test(expected = OrderStateException.class)
    public void OrderTestWhenOrderStateIsWrong() {
        order.confirm();
    }


}
