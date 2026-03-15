export interface Car {
  id?: number;
  type: string;
  plateNumber: string;
  model: string;
  clientId: number;
  clientName?: string; // For display purposes
}