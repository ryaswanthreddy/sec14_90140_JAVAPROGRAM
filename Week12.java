package com.klu.locker.app;
import com.klu.locker.model.*;
import com.klu.locker.service.*;
import java.nio.file.*;
import java.util.*;
public class Week12 {
    public static void main(String[] args) {
        Path stateFile  = Path.of("locker-state.csv");
        Path reportFile = Path.of("daily-report.txt");
        ParcelValidator   validator = new ParcelValidator();
        ParcelStore       store     = new ParcelStore(validator);
        ParcelRepository  repo      = new ParcelRepository();
        LockerWall        wall      = new LockerWall(4, 3);
        PickupCodeService codes     = new PickupCodeService();
        System.out.println("=== Campus Smart-Locker ===");
        List<Parcel> loaded = store.load(stateFile);
        for (Parcel p : loaded) {
            repo.add(p);
            codes.reserve(p.getPickupCode());
            if (p.getStatus() != ParcelStatus.COLLECTED && p.getLockerNumber() >= 0) {
                Locker lk = wall.byNumber(p.getLockerNumber());
                if (lk != null && lk.isFree()) lk.place(p);
            }
        }
        System.out.println(loaded.isEmpty()
            ? "(no saved state - starting fresh)"
            : "restored " + loaded.size() + " parcel(s) from " + stateFile);
        IntakeService intake = new IntakeService(repo, wall, codes, validator);
        PickupService pickup = new PickupService(repo, wall);
        Scanner sc = new Scanner(System.in);
        boolean running = true;
        while (running) {
            System.out.println("\n1) Receive  2) Pick up  3) Locker wall  4) Daily report  5) List parcels  0) Exit");
            System.out.print("> ");
            if (!sc.hasNextLine()) break;
            switch (sc.nextLine().trim()) {
                case "1" -> {
                    System.out.print("Recipient name : "); String name  = sc.nextLine();
                    System.out.print("Recipient email: "); String email = sc.nextLine();
                    System.out.print("Size (S/L)     : "); String size  = sc.nextLine();
                    System.out.print("Arrival hour   : "); String hour  = sc.nextLine();
                    System.out.println(intake.receive(name, email, size, hour));
                }
                case "2" -> {
                    System.out.print("Pickup code    : ");
                    System.out.println(pickup.pickup(sc.nextLine().trim()));
                }
                case "3" -> System.out.println(wall.render());
                case "4" -> {
                    String report = DailyReportService.build(repo.all());
                    System.out.println(report);
                    DailyReportService.writeTo(reportFile, report);
                    System.out.println("(written to " + reportFile + ")");
                }
                case "5" -> {
                    List<Parcel> sorted = repo.sortedBy(
                        Comparator.comparing((Parcel p) -> p.getOwner().getName()).thenComparing(Parcel::getId));
                    if (sorted.isEmpty()) System.out.println("(no parcels)");
                    for (Parcel p : sorted) System.out.println("  " + p);
                }
                case "0" -> running = false;
                default  -> System.out.println("  ? unknown option");
            }
        }
        store.save(repo, stateFile);
        System.out.println("Saved " + repo.all().size() + " parcel(s) to " + stateFile + ". Goodbye.");
    }
}