package com.bookstore.Heaven.s.Door.BookStore;

import com.bookstore.Heaven.s.Door.BookStore.Models.Librarian;
import com.bookstore.Heaven.s.Door.BookStore.repo.LibratianRepo;
import org.junit.jupiter.api.Assertions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;

import java.util.List;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static sun.jvm.hotspot.runtime.BasicObjectLock.size;

@SpringBootTest
@RunWith(SpringRunner.class)
public class LibrarianTest {
    @Autowired
    private LibratianRepo libRep;

    @Test
    public void searchBook() {
        Iterable<Librarian> library1 = libRep.search("По записям безумца");
        Librarian l = new Librarian(6L, "Маккензи Бэкон", "1899", "«По записям безумца» в деталях описывает тексты больного из приюта, который потратил 2 года в палате на то, чтобы заполнить каждый сантиметр огромного дневника своими дикими размышлениями и безумными стихами.", "По записям безумца", 1, "/img/forbooksfront/mad.png");

        Assertions.assertEquals(1, library1.spliterator().getExactSizeIfKnown());
    }

}
