

import com.max.*;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class BookingServiceTest {

    @Test
    void testBook_Positive() throws CantBookException {
        // Arrange
        BookingService bookingService = Mockito.spy(new BookingService());
        doReturn(true).when(bookingService).checkTimeInBD(any(), any()); // Мокируем проверку занятости
        doReturn(true).when(bookingService).createBook(any(), any(), any()); // Мокируем бронирование

        // Act
        boolean result = bookingService.book("userId", LocalDateTime.now(), LocalDateTime.now().plusHours(1));

        // Assert
        assertTrue(result);
        verify(bookingService, times(1)).checkTimeInBD(any(), any()); // Проверяем, что метод checkTimeInBD был вызван 1 раз
        verify(bookingService, times(1)).createBook(any(), any(), any()); // Проверяем, что метод createBook был вызван 1 раз
    }

    @Test
    void testBook_Negative() {
        // Arrange
        BookingService bookingService = Mockito.spy(new BookingService());
        doReturn(false).when(bookingService).checkTimeInBD(any(), any()); // Мокируем проверку занятости

        // Act & Assert
        assertThrows(CantBookException.class, () ->
                bookingService.book("userId", LocalDateTime.now(), LocalDateTime.now().plusHours(1))
        );
        verify(bookingService, times(1)).checkTimeInBD(any(), any()); // Проверяем, что метод checkTimeInBD был вызван 1 раз
        verify(bookingService, never()).createBook(any(), any(), any()); // Проверяем, что метод createBook не был вызван
    }
}
