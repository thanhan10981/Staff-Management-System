import { Routes } from '@angular/router';
import { Layout } from './core/layout/layout/layout';
import { DashboardComponent } from './features/dashboard/dashboard';
import { Employee } from './features/employee/employee';
import { SalaryDashboard } from './features/salary-management/salary-dashboard/salary-dashboard';
import { AllowanceOtManagement } from './features/salary-management/allowance-ot-management/allowance-ot-management';
import { SalaryExport } from './features/salary-management/salary-export/salary-export';

export const routes: Routes = [
  {
    path: '',
    component: Layout,
    children: [
      { path: '', redirectTo: 'dashboard', pathMatch: 'full' },
      { path: 'dashboard', component: DashboardComponent },
      { path: 'employees', component: Employee },
      { path: 'salary-overview', component: SalaryDashboard },
      { path: 'allowances', component: AllowanceOtManagement },
      { path: 'salary-report', component: SalaryExport },
    ],
  },
];
