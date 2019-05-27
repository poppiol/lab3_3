import edu.iis.mto.time.FakeSystemClock;
import edu.iis.mto.time.Order;
import edu.iis.mto.time.OrderExpiredException;
import org.joda.time.DateTime;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;

public class OrderTest {

    private Order order;
    private FakeSystemClock fakeSystemClock;

    @Before
    public void init(){
        fakeSystemClock = new FakeSystemClock();
        order = new Order(fakeSystemClock);

        }


    @Test(expected = OrderExpiredException.class)
    public void OrderTestWhenOrderIsCanceled(){
        fakeSystemClock.setTime(new DateTime(2019,5,27,10,0));
        order.submit();
        fakeSystemClock.setTime(new DateTime(2019,5,28,11,0));
        order.confirm();
    }
        @Test()
    public void OrderTestWhenOrderIsSubmitted(){
        fakeSystemClock.setTime(new DateTime(2019,5,27,10,0));
        order.submit();
            Assert.assertThat(order.getOrderState(), is(Order.State.SUBMITTED));
        }


}
